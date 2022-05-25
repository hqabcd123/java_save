import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class teamlab {
    static final String TOKEN = "Z1NKxHFgxfpYtLZYynov2p50PzLZKiQG";
    static final String BASE  = "https://runner.team-lab.com/";

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";



    public static String getSaltString(int len) {
        String SALTCHARS = "abcd";
//        String[] SALTCHARS = {"acacd", "aabdd", "dabda",
//                "dcaac", "bcbca", "dbbdc", "dbbab", "acaaa", "cadda", "cacca"};
        StringBuilder salt = new StringBuilder(), temp = new StringBuilder();
        //ArrayList<String> arrayList = new ArrayList<>();
        String[] array = {"aaa", "bbb", "ccc"};
        Random rnd = new Random();
        int count = 0;
        while (salt.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            char ch = SALTCHARS.charAt(index);
            temp.append(ch);
            count++;
            if (count == 3){
                for (String s : array){
                    if (!salt.toString().contains(s)){
                        salt.append(temp);
                        break;
                        //System.out.println(salt.toString());
                    }
                }
                count = 0;
                temp.delete(0, temp.length());
            }
        }
        System.out.println(salt.length()-1*-);
        salt.delete(salt.length()-1, salt.length());
        String saltStr = salt.toString();
        return saltStr;
    }

    public static void main(String[] args)throws IOException {
        File file = new File("mark4.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        //String str = "acacdaabcadabdadcaacbcbcadbcdcdbcabacabacadbacacca";
//        int mark = 0;
//        String  HeightestStr = "";
        //String[] str = {"bddd"};
        for (int i=0; i<30; i++) {
            String str = getSaltString(50);


            System.out.println("str : " + str);

            String url = BASE + "/q?token=" + TOKEN + "&str=" + str;
            String result = query(url);
            System.out.println(result);
//            if (Integer.valueOf(result) >= mark){
//                HeightestStr = str;
//                String[] strings = HeightestStr.split("");
//                for (String s : strings){
//                    System.out.println("str : " + s);
//                    url = BASE + "/q?token=" + TOKEN + "&str=" + s;
//                    result = query(url);
//                    System.out.println(result);
//                    try {
//                        Thread.sleep(1000L);
//                    } catch(InterruptedException e){}
//                }
//            }
            try{
                fileWriter.write(str + ":");
                fileWriter.write(result + "\n");
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000L);
            } catch(InterruptedException e){}
        }
        fileWriter.close();
    }

    public static String query(String _url) throws IOException {
        URL url = new URL(_url);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
            InputStreamReader isr = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            String res = "";
            String line = null;

            while((line = reader.readLine()) != null){
                res += line;
            }
            return res.trim();
        }
        return "";
    }
}
