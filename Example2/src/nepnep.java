

public class nepnep {
    public static void main( String [] args ) {
        String s = "Go to the main menu. Quick!";
        String ws [] = s.split(" ");

        for (int i=0; i<ws.length; i++){
            String w = ws[i];
            for (int c=w.length()-1; c>=0; c--){
                System.out.print(w.charAt(c));
            }
            System.out.print(" ");
        }
    }
}

