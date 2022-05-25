import javafx.geometry.Side;
import sun.security.provider.SHA;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Surface{
    double area();
    double perimeter();
    String toString();
    String toSave();
}
abstract class Shape implements Surface{
    int x, y;
    Shape(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Circle extends Shape{
    int r;
    double PI = 3.14;
    public double area(){
        return (double) PI*r*r;
    }
    public double perimeter(){
        return (double) 2*PI*r;
    }
    public void setR(int r){
        this.r = r;
    }
    public String toString(){
        return "Circle at (" + x + "," + y + ") has radius " + r;
    }
    public String toSave(){
        return "Circle," + x + "," + y + "," + r;
    }
    Circle (int x, int y, int r){
        super(x,y);
        this.r = r;
    }
}
class Square extends Shape{
    int SideOfLength;
    public double area(){
        return SideOfLength*SideOfLength;
    }
    public double perimeter(){
        return SideOfLength*4;
    }
    public void setSideOfLength(int SideOfLength){
        this.SideOfLength = SideOfLength;
    }
    public String toString(){
        return "Square at (" + x+ "," + y + ") has Length " + SideOfLength;
    }
    public String toSave(){
        return "Square," + x + "," + y + "," + SideOfLength;
    }
    Square(int x, int y, int SideOfLength){
        super(x,y);
        this.SideOfLength = SideOfLength;
    }
}
class Triangle extends Shape{
    int SideOfLength;
    public double area(){
        double l = SideOfLength/2.0;
        l = l/SideOfLength;
        l = Math.acos(l);
        l = SideOfLength*Math.sin(l);
        l *= SideOfLength;
        return (double) l/2;
    }
    public double perimeter(){
        return SideOfLength*3;
    }
    public String toString(){
        return "Triangle at (" + x+ "," + y + ") has Length " + SideOfLength;
    }
    public String toSave(){
        return "Triangle," + x + "," + y + "," + SideOfLength;
    }
    Triangle(int x, int y, int SideOfLength){
        super(x,y);
        this.SideOfLength = SideOfLength;
    }
}
class Rectangle extends Shape{
    int Width, Heigth;
    public double area(){
        return Heigth*Width;
    }
    public double perimeter(){
        return Width*2+Heigth*2;
    }

    public void setHeigth(int heigth) {
        Heigth = heigth;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public String toString(){
        return "Rectangle at (" + x+ "," + y + ") has width " + Width + " and height " + Heigth;
    }
    public String toSave(){
        return "Rectangle," + x + "," + y + "," + Width + "," + Heigth;
    }
    Rectangle(int x, int y, int Width, int Heigth){
        super(x,y);
        this.Heigth = Heigth;
        this.Width = Width;
    }
}



public class AssignmentB {
    public static void main(String[] args) throws IOException {
        boolean statement = true, SaveStatement = false;//control the wile loop
        String input;
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Shape> shape = new ArrayList<>();
        while (statement){
            System.out.println("Please select which function you want\n" +
                    "1. Create a new shape\n" +
                    "2. List all shape\n" +
                    "3. Save to file\n" +
                    "4. Load from file\n" +
                    "5. Remove shape from data\n" +
                    "6. Change the element from shape\n" +
                    "7. Quit");
            input = br.readLine();
            try {
                int IntInput = Integer.parseInt(input);
                if (IntInput < 0) System.out.println("Input is negative. Invalid action");
                else {
                    switch (IntInput){
                        case (1):{
                            shape = SelectShape(shape);
                            SaveStatement = true;
                            break;
                        }
                        case (2):{//List all shape
                            int i = 1;
                            double TotalArea = 0.0, TotalPerimeter = 0.0;
                            System.out.println("There are " + shape.size() + " shapes:");
                            for (int j = 0; j < shape.size(); j++) {
                                System.out.println("    " + i + ". " + shape.get(j).toString());
                                TotalArea += shape.get(j).area();
                                TotalPerimeter += shape.get(j).perimeter();
                                i++;
                            }
                            DecimalFormat d = new DecimalFormat("#.00");

                            System.out.println("The total area is " + d.format(TotalArea) + ", and\n" +
                                    "the total perimeter is " + d.format(TotalPerimeter) + "\n");
                            break;
                        }
                        case (3):{//Save
                            Saving(shape.size(), shape);
                            SaveStatement = false;
                            break;
                        }
                        case (4):{//Load
                            File f = null;
                            String[] path = new String[0];
                            int SelectedFile;
                            int i = 1, j = 0;
                            String str = "";
                            ArrayList<Integer> index = new ArrayList<>();
                            try {
                                System.out.println("Please input address and if you didn't enter anything " +
                                        "it will be default location: ");
                                str = br.readLine() + "\\";
                                if (str.equalsIgnoreCase("\\")){
                                    str = ".";
                                }
                                f = new File(str);
                                path = f.list();
                                for (String paths : path){
                                    if (paths.contains(".txt")){
                                        System.out.println(i + ". " + paths);
                                        index.add(j);
                                        i++;
                                    }
                                    j++;
                                }
                                if (str.equalsIgnoreCase("."))str = "";
                                System.out.println("\nPlease selected the txt file you want");
                                try {
                                    SelectedFile = Integer.parseInt(br.readLine());
                                    FileReader fr = new FileReader(str  + path[index.get(SelectedFile-1)]);
                                    System.out.println("Selected " + path[index.get(SelectedFile-1)]);
                                    int ch;
                                    ArrayList<Character>characterArrayList = new ArrayList<>();
                                    //Create a list for svaing the word in txt and try to recover from them
                                    while ((ch=fr.read()) != -1){
                                        characterArrayList.add((char)ch);
                                        System.out.print((char)ch);
                                    }
                                    //***************************************************
                                    StringBuilder builder = new StringBuilder(characterArrayList.size());
                                    for (char character : characterArrayList){
                                        builder.append(character);
                                    }
                                    String string = builder.substring(0);
                                    String[] data = string.split(",");
                                    System.out.println(data[3] + "\n\n");
                                    for (String s : data){
                                        if (s.contains("\n")){
                                        }
                                    }
                                    if (data[0].equalsIgnoreCase("Circle")){
                                        int x = Integer.parseInt(data[1].trim());
                                        int y = Integer.parseInt(data[2].trim());
                                        int R = Integer.parseInt(data[3].trim());
                                        System.out.println("loaded is " + x + y + R);
                                    }
                                    //This is transform those char list to string
                                    /*problem is when println, it will automatically print next string*/
                                    //***************************************************
                                    System.out.println("");
                                    fr.close();
                                }catch (NumberFormatException ne){
                                    System.out.println("Error code is " + ne + "\nInvalid action\n");
                                }
                            }catch (Exception e){
                                System.out.println("Error code is " + e + "\nInvalid action\n");
                            }
                            break;
                        }
                        case (5):{
                            System.out.println("Which shape you want to remove: ");
                            for (int i = 0; i < shape.size(); i++) {
                                System.out.println("    " + (i+1) + ". " + shape.get(i).toSave());
                            }
                            shape.remove(sc.nextInt()-1);
                            for (int i = 0; i < shape.size(); i++) {
                                System.out.println("    " + (i+1) + ". " + shape.get(i).toSave());
                            }
                            break;
                        }
                        case (6):{
                            System.out.println("Which shape you want to change: ");
                            for (int i = 0; i < shape.size(); i++) {
                                System.out.println("    " + (i+1) + ". " + shape.get(i).toSave());
                            }
                            int tempInput = sc.nextInt();
                            Shape temp = shape.get(tempInput-1);
                            shape.set(tempInput-1, SelectShape(shape).get(shape.size()-1));
                            shape.remove(shape.size()-1);
                            for (int i = 0; i < shape.size(); i++) {
                                System.out.println("    " + (i+1) + ". " + shape.get(i).toSave());
                            }
                            break;
                        }
                        case (7):{
                            if (SaveStatement){
                                System.out.println("Didn't save. Want to save(Y/N)");
                                String SavingChoice = br.readLine();
                                if (SavingChoice.equalsIgnoreCase("Y")){
                                    Saving(shape.size(), shape);
                                    System.out.println("Statement saved\n" +
                                            "Program finish");
                                    statement = false;
                                }
                                else if(SavingChoice.equalsIgnoreCase("N")) {
                                    System.out.println("Program finish");
                                    statement = false;
                                }
                                else {
                                    System.out.println("wrong statement");
                                }
                            }else statement = false;
                            break;
                        }
                        default:{
                            System.out.println("Input is out of value. Please input it again");
                            break;
                        }
                    }
                }
            }catch (NumberFormatException ne){
                System.out.println("Error code is " + ne + "\nAction doesn't succeed\n");
            }
        }
    }
    static ArrayList<Shape> RecoverData(ArrayList<Shape> shape){
        return shape;
    }
    static ArrayList<Shape> SelectShape(ArrayList<Shape> shape) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Create a new shape: \n  which shape you wanna create?\n" +
                "1. Square\n" +
                "2. Circle\n" +
                "3. Triangle\n" +
                "4. Rectangle");
        int SelectedShape = Integer.parseInt(br.readLine());
        try{
            if (SelectedShape < 0) System.out.println("Input is negative");
            switch (SelectedShape) {
                case (1): {
                    System.out.println("Selected Square" +
                            "\nPlease input the xy coordinate of this shape and length each by each");
                    //shape[NumberOfShape] = new Square(sc.nextInt(), sc.nextInt(), sc.nextInt());

                    String x = br.readLine(), y = br.readLine(), Length = br.readLine();
                    try {
                        int intx = Integer.parseInt(x), inty = Integer.parseInt(y), intLength = Integer.parseInt(Length);

                        if (intx < 0 || inty < 0 || intLength < 0){
                            System.out.println("Some element is negative number\n" +
                                    "Create doesn't succeed\n");
                        }
                        else shape.add(new Square(intx, inty, intLength));
                    }catch (NumberFormatException ne){
                        System.out.println("Error code is " + ne + "\nCreate doesn't succeed\n");
                    }
                    break;
                }
                case (2): {
                    System.out.println("Selected Circle" +
                            "\nPlease input the xy coordinate of this shape and radius each by each");
                    //shape[NumberOfShape] = new Circle(sc.nextInt(), sc.nextInt(), sc.nextInt());

                    String x = br.readLine(), y = br.readLine(), R = br.readLine();
                    try {
                        int intx = Integer.parseInt(x), inty = Integer.parseInt(y), intR = Integer.parseInt(R);

                        if (intx < 0 || inty < 0 || intR < 0){
                            System.out.println("Some element is negative number\n" +
                                    "Create doesn't succeed\n");
                        }
                        else shape.add(new Circle(intx, inty, intR));
                    }catch (NumberFormatException ne){
                        System.out.println("Error code is " + ne + "\nCreate doesn't succeed\n");
                    }
                    break;
                }
                case (3): {
                    System.out.println("Selected Triangle" +
                            "\nPlease input the xy coordinate of this shape and length each by each");
                    //shape[NumberOfShape] = new Triangle(sc.nextInt(), sc.nextInt(), sc.nextInt());

                    String x = br.readLine(), y = br.readLine(), Length = br.readLine();
                    try {
                        int intx = Integer.parseInt(x), inty = Integer.parseInt(y), intLength = Integer.parseInt(Length);

                        if (intx < 0 || inty < 0 || intLength < 0){
                            System.out.println("Some element is negative number\n" +
                                    "Create doesn't succeed\n");
                        }
                        else shape.add(new Triangle(intx, inty, intLength));
                    }catch (NumberFormatException ne){
                        System.out.println("Error code is " + ne + "\nCreate doesn't succeed\n");
                    }
                    break;
                }
                case (4): {
                    System.out.println("Selected Rectangle" +
                            "\nPlease input the xy coordinate of this shape, width and height each by each");
                    //shape[NumberOfShape] = new Rectangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                    String x = br.readLine(), y = br.readLine(), Width = br.readLine(), Height = br.readLine();
                    try {
                        int intx = Integer.parseInt(x), inty = Integer.parseInt(y), intWidth = Integer.parseInt(Width);
                        int intHeight = Integer.parseInt(Height);

                        if (intx < 0 || inty < 0 || intWidth < 0 || intHeight < 0){
                            System.out.println("Some element is negative number\n" +
                                    "Create doesn't succeed\n");
                        }
                        else shape.add(new Rectangle(intx, inty, intWidth, intHeight));
                    }catch (NumberFormatException ne){
                        System.out.println("Error code is " + ne + "\nCreate doesn't succeed\n");
                    }
                    break;
                }
                default: {
                    System.out.println("Input is out of value. Please input it again");
                    break;
                }
            }
        }catch (InputMismatchException ie){
            System.out.println("Error code" + ie);
        }catch (Exception e){
            System.out.println(e);
        }
        return shape;
    }
    static void Saving(int NumberOfShape, ArrayList<Shape> shape) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input location and if you didn't enter anything" +
                "it will be default location: ");
        String str = br.readLine() + "\\";//幫你入既location加\\
        if (str.equalsIgnoreCase("\\")){
            str = "";//如果只係得\\就改返做咩野都冇俾system default
        }
        System.out.println("Please input the txt name");
        String FileName= br.readLine();
        FileWriter fileWriter = new FileWriter(
                str + FileName + ".txt");
       /*整一個filewriter 個位置係你入既location加入左既file name
       再幫你自動加.txt上去*/
        for (int i = 0; i < NumberOfShape; i++) {
            fileWriter.write(shape.get(i).toSave());
            fileWriter.write('\n');
            //自動入各個shape既string之後加返個分段
        }
        fileWriter.flush();//將未入既data傳入file writer
        fileWriter.close();//close file writer
        /*
        * 1.    at "String str = bt.readline;" it will plugin a \\ to the location you typed
        * 2.    在if statement上decide如果只係得\\就改返做咩野都冇俾system default
        * 3.    FileWriter fileWriter = new FileWriter(str + FileName + ".txt");
        * 整一個filewriter 個位置係你入既location加入左既file name再幫你自動加.txt上去
        * 4.    add for loop statement we add a shape in txt each by each*/
    }
}
