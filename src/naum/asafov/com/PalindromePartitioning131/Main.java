package naum.asafov.com.PalindromePartitioning131;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

 */
public class Main {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = new Solution().partition(s);
        for (List<String> l : res){
            System.out.println(l.toString());
        }
    }
}

class Solution {
    List<List<String>> res;
    List<String> temp;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        temp = new ArrayList<String>();
        dfs(s);
        return res;
    }

    public void dfs(String s){
        // when s.isEmpty, our traversal of the string has reached the end
        if(s.isEmpty() && temp.size() > 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        //aab

        for(int i = 1; i <= s.length(); i ++){
            // get every possible partition on current substring
            String seg = s.substring(0,i);
            if(isPalin(seg)){
                temp.add(seg);
                // if the first half substring is valid, do dfs for the rest of substring
                dfs(s.substring(i));
                // remove the last element, typical behavior for backtracking
                temp.remove(temp.size()-1);
            }
        }

    }

    public boolean isPalin(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i ++;
            j --;
        }
        return true;
    }
}