import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.*;
import java.util.*;

class map{
    public String [][] b = new String[3][3];
    private int count = 1;



     void INputer(int x,int y){
                if (count%2 == 0) b[x][y] = "O";
                else b[x][y] = "X";
                count++;
    }
     void Creater(String [][]b){
        System.out.println("|" + b[0][0] + "|" + b[1][0] + "|" + b[2][0] + "|");
        System.out.println("======");
         System.out.println("|" + b[0][1] + "|" + b[1][1] + "|" + b[2][1] + "|");
         System.out.println("======");
         System.out.println("|" + b[0][2] + "|" + b[1][2] + "|" + b[2][2] + "|");
         System.out.println("======");
    }

    void Cleaner(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = " ";
            }
        }
    }

    public String[][] getB(){
        return b;
    }

    public boolean rule(){
        if ((b[0][0] == "O" & b[1][0] == "O" & b[2][0] == "O") |
                (b[0][0] == "X" & b[1][0] == "X" & b[2][0] == "X")) {
            System.out.println("win");
            return true;
        }
        else if ((b[0][1] == "O" & b[1][1] == "O" & b[2][1] == "O") |
                (b[0][1] == "X" & b[1][1] == "X" & b[2][1] == "X")) {
            System.out.println("win");
            return true;
        }
        else if ((b[0][2] == "O" & b[1][2] == "O" & b[2][2] == "O") |
                (b[0][2] == "X" & b[1][2] == "X" & b[2][2] == "X")) {
            System.out.println("win");
            return true;
        }
        else if ((b[0][0] == "O" & b[1][1] == "O" & b[2][2] == "O") |
                (b[0][0] == "X" & b[1][1] == "X" & b[2][2] == "X")) {
            System.out.println("win");
            return true;
        }
        else if ((b[0][2] == "O" & b[1][1] == "O" & b[2][0] == "O") |
                (b[0][2] == "X" & b[1][1] == "X" & b[2][0] == "X")) {
            System.out.println("win");
            return true;
        }
        else if ((b[0][0] == "X" & b[0][1] == "X" & b[0][2] == "X") |
                (b[0][0] == "O" & b[0][1] == "O" & b[0][2] == "O")){
            System.out.println("win");
            return true;
        }
        else if ((b[1][0] == "X" & b[1][1] == "X" & b[1][2] == "X") |
                (b[1][0] == "O" & b[1][1] == "O" & b[1][2] == "O")){
            System.out.println("win");
            return true;
        }
        else if ((b[2][0] == "X" & b[2][1] == "X" & b[2][2] == "X") |
                (b[2][0] == "O" & b[2][1] == "O" & b[2][2] == "O")){
            System.out.println("win");
            return true;
        }
        else return false;
    }




}

public class work2{
    public static void main(String[] args) {
        int i, j, x, y;
        String[][] Pointer = new String[3][3];
        Scanner sc = new Scanner(System.in);
        map Runner = new map();
        Runner.Cleaner();
        //-------------loop分隔線------------------
        while (true){
            System.out.println("input x and y");
            x = sc.nextInt();
            y = sc.nextInt();
            if (x>2 | y>2){
                System.out.println("wrong number");
                break;
            }
            Runner.INputer(x, y);
            Pointer = Runner.getB();
            Runner.Creater(Pointer);
            boolean winner = Runner.rule();
            if (winner){
                System.out.println("WIN!!!");
                return;
            }
        }
    }
}
