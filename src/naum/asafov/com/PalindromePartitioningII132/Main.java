package naum.asafov.com.PalindromePartitioningII132;

import java.util.ArrayList;
import java.util.List;
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

 */
public class Main {
    public static void main(String[] args) {
        String s = "aab";
        int i= new Solution().minCut(s);
        System.out.println(i);
    }
}
class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1)
            return 0;
        int[] dp = new int[n];
        dp[0] = 0;


        for(int i = 1; i < n; i++){
            dp[i] = dp[i-1] + 1;
            for(int j = i-1; j >= 0; j--){
                if(is_palidrome(s.substring(j, i+1))){
                    if(j == 0)
                        dp[i] = 0;
                    else
                        dp[i] = Math.min(dp[j-1]+1, dp[i]);
                }
            }
        }
        return dp[n-1];
    }

    public boolean is_palidrome(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

