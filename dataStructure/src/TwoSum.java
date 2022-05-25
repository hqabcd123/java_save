import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input a number: ");
        int num = sc.nextInt(), k = 1;
        /*1240%10=0 > 0
        * 124/10=4 > IV
        * 12%10=2 > II
        * 1 > I
        * I > II > III > IV > V > VI > VII > IIX > IX > X
        * X > XX*/
        ArrayList<Integer> list = new ArrayList();
        String strings = "";
        while (num != 0)
        {
            list.add(num%10);
            num /= 10;
        }
        System.out.println("list = " + list);
        for (int i : list)
        {
            System.out.println("number = " + i*k + ", Roman: " + intToRoman(i*k));
            strings = intToRoman(i*k) + strings;
            k *= 10;
        }
        System.out.println("Roman is " + strings.toString());
    }
    static String intToRoman(int num)
    {
        String str = "";
        char carry = 'I';
        boolean state = true;
        int[] value = {1000, 500, 100, 50, 10, 5, 1};
        char[] Roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        for (int i = 0; i < 7; i++)
        {
            if (num/value[i] > 0)
            {
                if (num/value[i] < 4)
                {
                    for (int j = 0; j < num/value[i]; j++)
                    {
                        str += Roman[i];
                    }
                }
                else if (num/value[i] > 4 && num/value[i] < 9)
                {
                    //str =
                }
            }
        }

//        if (num/1000 > 0){
//            carry = 'M';
//            num /= 1000;
//            state = false;
//        }
//        else if (num/800 > 0){
//            str = "M";
//            carry = 'C';
//            num /= 100;
//            num = 10-num;
//        }
//        else if (num/500 > 0){
//            str = "D";
//            num %= 500;
//            num /= 100;
//            carry = 'C';
//            state = false;
//        }
//        else if (num/100 > 0){
//            carry = 'C';
//            num /= 100;
//            state = false;
//        }
//        else if (num/80 > 0){
//            str = "C";
//            carry = 'X';
//            num /= 10;
//            num = 10-num;
//        }
//        else if (num/50 > 0){
//            str = "L";
//            num %= 50;
//            num /= 10;
//            carry = 'X';
//            state = false;
//        }
//        else if (num == 40) {
//            str = "C";
//            carry = 'X';
//            num = 1;
//        }
//        else if (num/10 > 0){
//            carry = 'X';
//            num /= 10;
//            state = false;
//        }
//        else if (num/8 > 0){
//            str = "X";
//            num = 10-num;
//        }
//        else if (num/5 > 0){
//            str = "V";
//            num %= 5;
//            state = false;
//        }
//        else if (num == 4) {
//            str = "V";
//            num = 1;
//        }
        for (int i = 0; i < num; i++) {
            str = (state)?carry + str : str + carry;
        }
        return str;
    }
}
