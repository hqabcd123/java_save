import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Scanner;
class BubbleSort{
    static void bubbleSort(ICanCompare[] objs){
        for (int i = objs.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (objs[j].compare(objs[j + 1])<0){
                    ICanCompare temp = objs[j];
                    objs[j] = objs[j + 1];
                    objs[j + 1] = temp;
                }
            }
        }
    }
}
interface ICanCompare{
    int compare(ICanCompare i);
}

abstract class Land implements ICanCompare{
    abstract double area();//計算面積
    public int compare(ICanCompare i){
        Land l = (Land) i;
        return (int)(this.area() - l.area());
    }
}
class Circle extends Land{
    int r;
    Circle(int r){
        this.r = r;
    }
    double area(){
        return 3.141 * r * r;
    }

    @Override
    public String toString() {
        return "半徑" + r + ",面積" + area() + "的圓";
    }
}
class Square extends Land{
    int side;
    double area(){
        return side * side;
    }
    Square(int side){
        this.side = side;
    }

    @Override
    public String toString() {
        return "直徑" + side + ",面積" + area() + "的正方形";
    }
}
class Tringle extends Land{
    int side, h;
    double area(){return (side * h)/2;}
    Tringle(int side, int h){
        this.h = h;
        this.side = side;
    }
}
class Utility {
    double max(Land...Lands){
        double MaxArea = 0;
        for(Land l : Lands){
            if (l.area() > MaxArea)MaxArea = l.area();
        }
        return MaxArea;
    }
}
class Cal{
    int price;
    double Caler(Land l){
        return CalAllPrice(price, l);
    }
    double Caler(double price, Land l){return l.area() * price;}
    double CalAllPrice(Land...Lands){return CalAllPrice(price, Lands);}
    double CalAllPrice(double price, Land...Lands){
        double total = 0;
        for(Land l : Lands){
            total += Caler(price, l);
        }
        return total;
    }
    Cal(int price){this.price = price;}
}


public class work {
    public static void main(String[] args) throws IOException {
        Circle c = new Circle(4);
        Square s = new Square(7);
        Tringle t = new Tringle(6,7);
        Cal ca = new Cal(1570);
        Utility utility = new Utility();
        System.out.println(
                "total price= "+ ca.CalAllPrice(c,s)
        );
        c.r = 7;
        System.out.println("total price= "+ ca.CalAllPrice(c,s));
        System.out.println("price in 4000: "+ ca.CalAllPrice(4000, c, s));
        System.out.println("price in Tringle is = "+ ca.Caler(6000, t));
        System.out.println("Max area in this land is "+ utility.max(c, s, t));
        Land[] lands = {
                new Circle(4),
                new Circle(7),
                new Square(8),
                new Circle(14),
                new Square(9)
        };
        for (Land l : lands){
            System.out.println(l);
        }
        System.out.println("SORT測試\n\n");
        BubbleSort.bubbleSort(lands);
        for (Land l : lands){
            System.out.println(l);
        }
    }
}
