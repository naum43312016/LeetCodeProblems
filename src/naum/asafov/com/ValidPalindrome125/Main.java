package naum.asafov.com.ValidPalindrome125;
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 */
public class Main {
    public static void main(String[] args) {
        String s = "race a car";
        boolean i = new Solution().isPalindrome(s);
        System.out.println(i);
    }
}


class Solution {
    public boolean isPalindrome(String s) {
        if (s==null){
            return false;
        }
        if (s.length()==0){
            return true;
        }
        int i=0;
        int j = s.length()-1;

        while (i<s.length() && j>-1) {

            while ((i < s.length()&& (int)s.charAt(i) < 48)
            || (i < s.length()&&(int) s.charAt(i) > 57 && (int) s.charAt(i) < 65)
            || i < s.length()&&(int) s.charAt(i) > 90&&(int) s.charAt(i) < 97
            || (i < s.length()&&(int) s.charAt(i) >122))
            {
                i++;
            }



            while ((j >-1&&(int) s.charAt(j) < 48)
            || (j >-1&&(int) s.charAt(j) > 57 && (int) s.charAt(j) < 65)
            || (j >-1&&(int) s.charAt(j) > 90&&(int) s.charAt(j) < 97)
            || (j >-1&&(int) s.charAt(j) >122)){
                j--;
            }

            if (i<s.length() && j>-1) {
                String l = String.valueOf(s.charAt(i));
                String r = String.valueOf(s.charAt(j));
                if (l.equalsIgnoreCase(r)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}