package naum.asafov.com.palindrome;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "babadada";
        String answer = new Solution().longestPalindrome(str);
        System.out.println(answer);

    }
}

class Solution {
    String longestPalindrome(String s) {
        if (s == null || s.equals("")){
            return "";
        }

        if (s.length()== 1){
            return s;
        }
        char[] arr = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        Palindrome palindrome = null;
        for (int i = 0 ;i<arr.length;i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }else {
                int left = map.get(arr[i]);
                Palindrome pal = isPalindrome(s,arr,left,i+1);
                if (pal!=null){
                    if (palindrome==null){
                        palindrome = pal;
                    }else {
                        if (pal.getLength() > palindrome.getLength()){
                            palindrome = pal;
                        }
                    }
                }

            }
        }

        System.out.println("Map = " + map.toString());
        if (palindrome == null) {
            return s.substring(0,1);
        }else {
            return s.substring(palindrome.getLeft(),palindrome.getRight()+1);
        }
    }

    private Palindrome isPalindrome(String s,char[] arr,int left,int right){
        String reverse = "";
        String original = s.substring(left,right);
        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse)){
            System.out.println(original);
            return new Palindrome(length,left,right-1);
        }else {
            return null;
        }
    }

}
class Palindrome{
    private int length;
    private int left;
    private int right;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public Palindrome(int length, int left, int right) {
        this.length = length;
        this.left = left;
        this.right = right;
    }
}