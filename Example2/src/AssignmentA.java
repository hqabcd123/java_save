import javafx.geometry.Side;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

interface Surface{
    double area();
    double perimeter();
    String toString();
    String toSave();
}
abstract class Shape implements Surface{
    double x, y;
    Shape(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Circle extends Shape{
    int r;
    public double area(){
        return Math.PI*r*r;
    }
    public double perimeter(){
        return 2*Math.PI*r;
    }
    public String toString(){
        return "Circle at (" + x + "," + y + ") has radius " + r;
    }
    public String toSave(){
        return "Circle, " + x + ", " + y + ", " + r;
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
        return SideOfLength+SideOfLength;
    }
    public String toString(){
        return "Square at (" + x+ "," + y + ") has Length " + SideOfLength;
    }
    public String toSave(){
        return "Square, " + x + ", " + y + ", " + SideOfLength;
    }
    Square(int x, int y, int SideOfLength){
        super(x,y);
        this.SideOfLength = SideOfLength;
    }
}
class Triangle extends Shape{
    int SideOfLength;
    public double area(){
        return (SideOfLength*SideOfLength)/2;
    }
    public double perimeter(){
        return SideOfLength*3;
    }
    public String toString(){
        return "Triangle at (" + x+ "," + y + ") has Length " + SideOfLength;
    }
    public String toSave(){
        return "Triangle, " + x + ", " + y + ", " + SideOfLength;
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
        return Width+Heigth;
    }
    public String toString(){
        return "Rectangle at (" + x+ "," + y + ") has width " + Width + " and height " + Heigth;
    }
    public String toSave(){
        return "Rectangle, " + x + ", " + y + ", " + Width + ", " + Heigth;
    }
    Rectangle(int x, int y, int Width, int Heigth){
        super(x,y);
        this.Heigth = Heigth;
        this.Width = Width;
    }
}



public class AssignmentA {
    public static void main(String[] args) throws IOException {
        boolean statement = true;//control the wile loop
        int input, NumberOfShape = 0;
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Shape[] shape = new Shape[10];
        while (statement){
            System.out.println("Please select which function you want\n" +
                    "1. Create a new shape\n" +
                    "2. List all shape\n" +
                    "3. Save to file\n" +
                    "4. Load from file\n" +
                    "5. Quit");
            input = sc.nextInt();
            switch (input){
                case (1):{//Create a new shape
                    System.out.println("Create a new shape: \n  which shape you wanna create?\n" +
                            "1. Square\n" +
                            "2. Circle\n" +
                            "3. Triangle\n" +
                            "4. Rectangle");
                    int SelectedShape = sc.nextInt();
                    switch (SelectedShape){
                        case (1):{
                            System.out.println("Selected Square" +
                            "\nPlease input the xy coordinate of this shape and length each by each");
                            shape[NumberOfShape] = new Square(sc.nextInt(), sc.nextInt(), sc.nextInt());
                            NumberOfShape++;
                            break;
                        }
                        case (2):{
                            System.out.println("Selected Circle" +
                                    "\nPlease input the xy coordinate of this shape and radius each by each");
                            shape[NumberOfShape] = new Circle(sc.nextInt(), sc.nextInt(), sc.nextInt());
                            NumberOfShape++;
                            break;
                        }
                        case (3):{
                            System.out.println("Selected Triangle" +
                                    "\nPlease input the xy coordinate of this shape and length each by each");
                            shape[NumberOfShape] = new Triangle(sc.nextInt(), sc.nextInt(), sc.nextInt());
                            NumberOfShape++;
                            break;
                        }
                        case (4):{
                            System.out.println("Selected Rectangle" +
                                    "\nPlease input the xy coordinate of this shape, width and height each by each");
                            shape[NumberOfShape] = new Rectangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                            NumberOfShape++;
                            break;
                        }
                        default:{
                            System.out.println("Input is out of value. Please input it again");
                            break;
                        }
                    }
                    break;
                }
                case (2):{//List all shape
                    int i = 1, TotalArea = 0, TotalPerimeter = 0;
                    System.out.println("There are " + NumberOfShape + " shapes:");
                    for (int j = 0; j < NumberOfShape; j++) {
                        System.out.println("    " + i + ". " + shape[j].toString());
                        TotalArea += shape[j].area();
                        TotalPerimeter += shape[j].perimeter();
                        i++;
                    }
                    System.out.println("The total area is " + TotalArea + ", and\n" +
                            "the total perimeter is " + TotalPerimeter + "\n");
                    break;
                }
                case (3):{//Save
                    Saving(NumberOfShape, shape);
                    break;
                }
                case (4):{//Quit
                    File f = null;
                    String[] path = new String[0];
                    int SelectedFile;
                    int i = 1, j = 0;
                    String str = "";
                    ArrayList<Integer> index = new ArrayList<>();
                    try {
                        System.out.println("Please input address: ");
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
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if (str.equalsIgnoreCase("."))str = "";
                    System.out.println("\nPlease selected the txt file you want");
                    SelectedFile = sc.nextInt();
                    FileReader fr = new FileReader(str  + path[index.get(SelectedFile-1)]);
                    System.out.println("Selected " + path[index.get(SelectedFile-1)]);
                    int ch;
                    while ((ch=fr.read()) != -1){
                        System.out.print((char)ch);
                    }
                    System.out.println("");
                    fr.close();
                    break;
                }
                case (5):{
                    System.out.println("Want to save(Y/N)");
                    String SavingChoice = br.readLine();
                    if (SavingChoice.equalsIgnoreCase("Y")){
                        Saving(NumberOfShape, shape);
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
                    break;
                }
                default:{
                    System.out.println("Input is out of value. Please input it again");
                    break;
                }
            }
        }
    }
    static void Saving(int NumberOfShape, Shape[] shape) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input address: ");
        String str = br.readLine() + "\\";
        if (str.equalsIgnoreCase("\\")){
            str = "";
        }
        System.out.println("Please input the txt name");
        String FileName= br.readLine();
        FileWriter fileWriter = new FileWriter(
                str + FileName + ".txt");
        for (int i = 0; i < NumberOfShape; i++) {
            fileWriter.write(shape[i].toSave());
            fileWriter.write('\n');
        }
    }
}
