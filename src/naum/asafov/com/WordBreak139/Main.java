package naum.asafov.com.WordBreak139;

import java.util.*;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

 */
public class Main {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] w = {"code","lodfas","fasf","leet"};
        boolean a = new Solution().wordBreak(s,new ArrayList<>(Arrays.asList(w)));
        System.out.println(a);
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int L= s.length();
        boolean[] dp = new boolean[L + 1];
        dp[L]=true;
        Map<Integer, Set<String>> hm = new HashMap<>();
        for(String x:wordDict){
            Set<String> ss=hm.getOrDefault(x.length(),new HashSet<>());
            ss.add(x);
            hm.put(x.length(),ss);
        }
        for(int i=L;i>=1;i--){
            if(dp[i]){
                for(Map.Entry<Integer,Set<String>> es:hm.entrySet()){
                    int p=i-es.getKey();
                    if(p>=0 && !dp[p]){
                        dp[p]=es.getValue().contains(s.substring(p,i));
                    }
                }
            }
        }
        return dp[0];
    }

}