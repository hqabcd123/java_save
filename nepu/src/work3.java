

/*
showInfoByName.PickUper
at showInfoByName.INputer
at work3.main
三者也是沒有分佈到空間的陣列參考
要修改
*/
/*
import javax.security.auth.Subject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Topic{
    private String name, Brd, Subjects, topic;
    private long number;
    private int years;
    void list(String topic, String name, String Brd, long number, int years){
        System.out.println(topic);
        System.out.println("姓名: "+ name);
        System.out.println("出生年: "+ Brd);
        System.out.println("學號: "+ number);
        System.out.println("年級: "+ years);
    }
    void list(String topic, String name, String Brd, String Subject){
        System.out.println(topic);
        System.out.println("姓名: "+ name);
        System.out.println("出生年: "+ Brd);
        System.out.println("科目: "+ Subject);
    }



    Topic(String topic, String name, String Brd, long number, int years){
        this.Brd = Brd;
        this.name = name;
        this.number = number;
        this.years = years;
        this.topic = topic;
    }
    Topic(String topic, String name, String Brd, String Subject){
        this.Brd = Brd;
        this.Subjects = Subjects;
        this.name = name;
        this.topic = topic;
    }
    Topic(){}
}

class showInfoByName extends Topic{
    showInfoByName(String name, String Brd, String Subjects){
        this.name = name;
        this.Brd = Brd;
        this.Subjects = Subjects;
    }
    showInfoByName(String name, String Brd, int years, long number){
        this.name = name;
        this.Brd = Brd;
        this.years = years;
        this.number = number;
    }
    private String name, Brd, Subjects;
    private int years;
    private long number;

    void INputer(String str){//把字傳入array
        // 這錯了要改
        this.name[i] = str;
        this.i++;
        PickUper(name);
        quickSort(0, name.length - 1);
    }

    //*******************************************************


    String getName(){
        return name;
        }
    String getBrd(){
        return Brd;
    }
    String getSubjects(){
        return Subjects;
    }
    int getYears(){
        return years;
    }
    long getNumber(){
        return number;
    }
    boolean Comparer(String string, String string1){
        if (string.compareToIgnoreCase(string1)>0)return true;
        else if (string.compareToIgnoreCase(string1)<0)return false;
        else {
            System.out.println("Comparer was worng");
            return false;
        }
    }

    void quickSort(int start, int end){//快速排序
        if (start<=end){
            return;
        }
        int mid = (start + end)/2;
        int left = start;
        int right = end;


        //*****************************************************************


        while(left <right){
            while(left<end && Comparer(SavedName[left], SavedName[mid])){
                left++;
            }
            while (right>start && Comparer(SavedName[right], SavedName[mid])){
                right--;
            }
            if (left<=right){
                String temp = SavedName[left];
                SavedName[left] = SavedName[right];
                SavedName[right] = temp;
                left++;
                right--;

            }
        }
    }
}
class Answer{
    boolean check(String answer){//check if you want yo continues
        if (answer.equalsIgnoreCase("yes")){
            return true;
        }
        else if (answer.equalsIgnoreCase("no")){
            return false;
        }
        else{
            return false;
        }
    }
}


public class work3 {
    public static void main(String[] args) throws IOException{
        String name, Brd, Subjects, topic;
        String answer = "yes";
        long number;
        int years;
        //object action


        //*******************************************************

        Answer an = new Answer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        Topic t = new Topic();
        ArrayList list = new ArrayList();


        //main function
        System.out.println("input your topic");
        topic = br.readLine();

        //**************************************************************

        while (an.check(answer)){


            System.out.println("input your name");
            name = br.readLine();

            System.out.println("input your Brd");
            Brd = br.readLine();

            if (topic.equalsIgnoreCase("teacher")){
                System.out.println("input your Subject");
                Subjects = br.readLine();
                showInfoByName show = new showInfoByName(name, Brd, Subjects);
                //input it in to a method
                list.add(show);
                list.sort();


                t.list(topic, name, Brd, Subjects);
            }

            else if (topic.equalsIgnoreCase("student")){
                System.out.println("input your years");
                years = sc.nextInt();
                System.out.println("input your number");
                number = sc.nextLong();
                answer = br.readLine();
                System.out.println(answer);
                showInfoByName show = new showInfoByName(name, Brd, years, number);
                //input it in to a method
                list.add(show);

                t.list(topic, name, Brd, number, years);
            }

            else System.out.println("worng input");


            System.out.println("will you want to continues?");
            answer = br.readLine();
            System.out.println(answer);
        }
    }
}
*/