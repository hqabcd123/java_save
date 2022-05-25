import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class work2 {
    public static void main(String[] args) {
        double[] SaveedNumber = new double[1000000];
        int InputNumber, maxNumber = 0;
        System.out.println("input a number");
        Scanner sc = new Scanner(System.in);
        InputNumber = sc.nextInt();
        List<String> SavedList = new ArrayList<String>();
        for (int i = 1; i <= InputNumber; i++) {
            SaveedNumber[i] = Math.pow(2, i);
        }
        for (int i =1; i <= InputNumber; i++) {
            System.out.println("log2 " + i);
            System.out.println("0b: " + Long.toBinaryString(Double.doubleToLongBits(SaveedNumber[i])));
            for (int j = 0; (j = Long.toBinaryString(Double.doubleToLongBits(SaveedNumber[i]))
                    .indexOf("1", j)) != -1; j++) {
                SavedList.add(Integer.toString(j));
            }
            if (SavedList.size() > maxNumber){
                System.out.println(SavedList);
                maxNumber = i;
            }
            SavedList.clear();
        }
        System.out.println("Largest number is : log2 " + maxNumber);
    }
}
