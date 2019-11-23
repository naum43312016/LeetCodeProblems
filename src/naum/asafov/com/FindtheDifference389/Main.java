package naum.asafov.com.FindtheDifference389;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        char ans = new Solution().findTheDifference(s,t);
        System.out.println("Answer = " + ans);
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        char res;
        List<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()){
            list.add(c);
        }
        //System.out.println(list.toString());
        for (char c : t.toCharArray()){
            if (list.contains(c)){
                list.remove(new Character(c));
            }else {
                return c;
            }
        }
        return '0';
    }
}