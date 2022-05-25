import java.util.Scanner;


public class task {
    public static void main(String[] args) {
        System.out.println("abcde is a palindrome? : " +
                isPalindrome("abcda"));
        System.out.println("abcba is a palindrome? : " +
                isPalindrome("abcba"));

    }
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1){
            return true;
        }
        return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
    }
}