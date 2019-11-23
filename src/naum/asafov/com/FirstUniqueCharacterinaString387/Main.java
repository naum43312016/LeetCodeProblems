package naum.asafov.com.FirstUniqueCharacterinaString387;

import java.util.*;

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

 */
public class Main {
    public static void main(String[] args) {

        String s = "leetcode";
        int ans = new Solution().firstUniqChar(s);
        System.out.println(ans);

    }
}


class Solution {
    public int firstUniqChar(String s) {
        if (s==null || s.length()<1){
            return -1;
        }
        if (s.length()==1){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        for (int i =0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i))>-1){
                    arr[map.get(s.charAt(i))] = '0';
                    arr[i] = '0';
                    map.put(s.charAt(i),-1);
                }else {
                    arr[i] = '0';
                }
            }else {
                map.put(s.charAt(i),i);
            }
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]!='0') return i;
        }
        return -1;
    }
}