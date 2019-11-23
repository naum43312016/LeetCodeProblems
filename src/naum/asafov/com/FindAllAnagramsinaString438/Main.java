package naum.asafov.com.FindAllAnagramsinaString438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class Main {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> list = new Solution().findAnagrams(s,p);
        System.out.println(list.toString());

    }
}
class Solution {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> findAnagrams(String s, String p) {
        if (s==null || p==null || s.length()==0 || p.length()==0 || p.length()>s.length()) return list;

        if (s.length()==p.length()){
            if (s.equals(p)){
                list.add(0);
                return list;
            }else{
                char[] sArr = s.toCharArray();
                char[] pArr = p.toCharArray();
                Arrays.sort(sArr);
                Arrays.sort(pArr);
                if (new String(sArr).equals(new String(pArr))){
                    list.add(0);
                }
            }
            return list;
        }

        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String pStr = new String(pArr);
        for (int i=0;i<=s.length()-p.length();i++){
            isAnagram(i,s,pStr);
        }
        return list;
    }
    private void isAnagram(int i,String s, String p){
        String subS = s.substring(i,i+p.length());
        char[] sArr = subS.toCharArray();
        Arrays.sort(sArr);
        if (new String(sArr).equals(p)){
            list.add(i);
        }
    }
}