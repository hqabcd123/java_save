

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
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
        return SideOfLength*4;
    }
    public void setSideOfLength(int SideOfLength){
        this.SideOfLength = SideOfLength;
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
        return "Rectangle, " + x + ", " + y + ", " + Width + ", " + Heigth;
    }
    Rectangle(int x, int y, int Width, int Heigth){
        super(x,y);
        this.Heigth = Heigth;
        this.Width = Width;
    }
}


class CreateShape extends KeyAdapter implements ActionListener{
    String[] label = {"Choose a shape you want to build", "Circle", "Square", "Triangle", "Rectangle"};
    JButton Create = new JButton("Input");
    JTextField textField = new JTextField();
    JComboBox comboBox = new JComboBox(label);
    JLabel result = new JLabel(" ", SwingConstants.CENTER);
    JLabel remind = new JLabel(" ", SwingConstants.CENTER);
    JFrame myframe = new JFrame("Create new shape");

    int[] dataTemp = new int[4];
    int i = 0;
    boolean statement = false;

    ArrayList<Shape> shape = new ArrayList<>();
    int ObjectOfShape;

    public CreateShape(ArrayList<Shape> shape){

        this.shape = shape;

        Container contentpane = myframe.getContentPane();

        contentpane.add(remind, BorderLayout.NORTH);
        contentpane.add(textField, BorderLayout.CENTER);
        contentpane.add(comboBox, BorderLayout.WEST);
        contentpane.add(Create, BorderLayout.EAST);
        contentpane.add(result, BorderLayout.SOUTH);



        Create.addActionListener(this);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println("Enter");
                    InputData();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        comboBox.setEditable(false);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JComboBox)e.getSource()).getSelectedIndex());
                ObjectOfShape = ((JComboBox)e.getSource()).getSelectedIndex();
                if (i != 0){
                    JOptionPane.showMessageDialog(null, "All input will be clear");
                }
                i = 0;
                remind.setText("Please input x");
            }
        });

        myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myframe.setSize(400, 120);
        myframe.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        InputData();
    }
    public void InputData(){
        try {
            /*click the create button than build a new frame
            * read a data from text field and if input large than 0
             * put data to array and make a decision when i = 3 and JComobox's choose is not Rectangle
             * if Rectangle than i must = 4
             * than set statement to true and create a new shape
             * than break*/
            int temp = Integer.parseInt(textField.getText());
            if (temp < 0)JOptionPane.showMessageDialog(null, "input is negative");
            else {
                dataTemp[i] = temp;
                textField.setText("");
                System.out.println("i = " + i + ", and input = " + dataTemp[i]);
                String[] strings = {};
                switch (ObjectOfShape){
                    case (1):{
                        strings = new String[]{"Please input y", "Please input R", "Shape created"};
                        break;
                    }
                    case (2):{
                        strings = new String[]{"Please input y", "Please input Length", "Shape created"};
                        break;
                    }
                    case (3):{
                        strings = new String[]{"Please input y", "Please input Length", "Shape created"};
                        break;
                    }
                    case (4):{
                        strings = new String[]{"Please input y", "Please input Width", "Please input Height", "Shape created"};
                        break;
                    }
                }
                if (i == 3 && ObjectOfShape == 4){
                    statement = true;
                    i = 0;
                }
                else if (i == 2 && ObjectOfShape < 4 && ObjectOfShape != 0){
                    statement = true;
                    i = 0;
                }
                else if (ObjectOfShape == 0){
                    JOptionPane.showMessageDialog(null, "Please choose a shape");
                    i = 0;
                }
                remind.setText(strings[i]);
                if (statement){
                    switch (ObjectOfShape){
                        case (1):{
                            shape.add(new Circle(dataTemp[0], dataTemp[1], dataTemp[2]));
                            i = 0;
                            break;
                        }
                        case (2):{
                            shape.add(new Square(dataTemp[0], dataTemp[1], dataTemp[2]));
                            i = 0;
                            break;
                        }
                        case (3):{
                            shape.add(new Triangle(dataTemp[0], dataTemp[1], dataTemp[2]));
                            i = 0;
                            break;
                        }
                        case (4):{
                            shape.add(new Rectangle(dataTemp[0], dataTemp[1], dataTemp[2], dataTemp[3]));
                            i = 0;
                            break;
                        }
                        default:{
                            System.out.println("Create a new shape was fail");
                            break;
                        }
                    }
                    remind.setText("Please input x");
                    statement = false;
                    System.out.println(shape);
                }
                else i++;
                result.setText(shape.toString());
            }
        }catch (NumberFormatException ne){
            textField.setText("");
            System.out.println(ne);
            JOptionPane.showMessageDialog(null, "Input Invalid, please input a number");
        }catch (ArrayIndexOutOfBoundsException ae){
            System.out.println("Error code" + ae);
            textField.setText("");
            System.out.println("Didn't choose a shape, please choose a shape");
        }catch (Exception e){
            System.out.println(e);
            textField.setText("");
        }
    }
}
public class AssignmentC extends JPanel implements ActionListener{
    JButton Create = new JButton("Create a new shape");
    JButton List = new JButton("List all shape");
    static boolean SavedStatement = false;
    JTextArea txt = new JTextArea(80, 80);
    JTextArea area = new JTextArea(80, 80);
    JFileChooser fileChooser = new JFileChooser(".");
    public static void main(String[] args) {
        AssignmentC simpleListenenr = new AssignmentC();
        simpleListenenr.setLayout(new GridLayout(5, 1));
        JFrame myframe = new JFrame("Shape");
        myframe.getContentPane().add(simpleListenenr);
        myframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        myframe.setSize(400, 120);
        myframe.setVisible(true);

        myframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (SavedStatement){
                    int state = JOptionPane.showConfirmDialog(
                            null, "Didn't save, sure want to go", "title", JOptionPane.YES_NO_OPTION);
                    switch (state){
                        case 0:{
                            System.exit(0);
                            break;
                        }
                        case 1:{
                            break;
                        }
                        default:break;
                    }
                }else System.exit(0);
            }
        });
    }
    public AssignmentC(){
        ArrayList<Shape> shape = new ArrayList<>();
        txt.setEditable(false);
        add(buildMenu());
        add(Create);
        add(List);
        add(txt);
        add(area);
        txt.setEditable(false);
        area.setEditable(false);


        Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateShape createShape = new CreateShape(shape);
                System.out.println("this createShape is having :" + createShape.shape);
                SavedStatement = true;
            }
        });
        List.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double TotalArea = 0.0, TotalPerimeter = 0;
                txt.setText(ListAllShape(shape));
                for (Shape s : shape){
                    TotalArea += s.area();
                    TotalPerimeter += s.perimeter();
                    System.out.println("Area: " + s.area());
                }
                DecimalFormat d = new DecimalFormat("#.00");

                System.out.println("The total area is " + d.format(TotalArea) + ", and\n" +
                        "the total perimeter is " + d.format(TotalPerimeter) + "\n");
                area.setText("TotalArea = " + d.format(TotalArea) +
                        ", TotalPerimeter = " + d.format(TotalPerimeter));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public String ListAllShape(ArrayList<Shape> shape){
        System.out.println("inside ListAllShape Method");
        return shape.toString();
    }
    public JMenuBar buildMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu menu = new JMenu("File (F)");
        menu.setMnemonic(KeyEvent.VK_F);
        mbar.add(menu);

        JMenuItem item = new JMenuItem("Save (S)", KeyEvent.VK_S);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writefile();
            }
        });
        menu.add(item);
        item = new JMenuItem("Open (O)", KeyEvent.VK_O);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readfile();
            }
        });
        menu.add(item);
        item = new JMenuItem("Quit (X)", KeyEvent.VK_X);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SavedStatement){
                    int statement = JOptionPane.showConfirmDialog(null , "Want to save?");
                    System.out.println("Selected option is " + statement);
                    switch (statement){
                        case (0):{//yes
                            System.out.println("yes");
                            writefile();
                            System.exit(0);
                            break;
                        }
                        case (1):{//no
                            System.exit(0);
                            break;
                        }
                        case (2):{
                            break;
                        }default:break;
                    }
                }else System.exit(0);
            }
        });
        menu.add(item);
        return mbar;
    }
    public void readfile(){
        System.out.println("readfile");
        int state = fileChooser.showOpenDialog(this);
        if (state == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                txt.read(new FileReader(file), "");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
    public void writefile(){
        SavedStatement = false;
        System.out.println("writefile");
        int state = fileChooser.showSaveDialog(this);
        if (state == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                txt.write(new FileWriter(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
