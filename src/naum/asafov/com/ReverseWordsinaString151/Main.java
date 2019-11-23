package naum.asafov.com.ReverseWordsinaString151;

import java.util.Arrays;

/*
Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.



 */
public class Main {
    public static void main(String[] args) {
        String s = "  hello world!  ";
        /*String[] arr = s.split(" ");
        System.out.println(arr[2]+arr[3]);
        System.out.println(Arrays.toString(arr));*/
        String ans = new Solution().reverseWords(s);
        System.out.println("Answer is:" + ans);
    }
}

class Solution {
    public String reverseWords(String s) {

        StringBuilder str = new StringBuilder();
        String[] arr = s.split(" ");
        System.out.println("S"+str.length());
        for (int i = arr.length-1;i>=0;i--){
            if (arr[i].length()>0 && !arr[i].equals(" ")){
                if (arr[i].charAt(0)!=32){
                    if (str.length()>0){
                        str.append(" ");
                    }
                    str.append(arr[i]);
                }
            }
        }

        return str.toString();
    }
}