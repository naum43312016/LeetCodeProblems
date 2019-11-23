package naum.asafov.com.LongestIncreasingSubsequence300;

public class Main {
    public static void main(String[] args) {
        //int[] arr = {10,9,2,5,3,7,101,18};
        int[] arr = {4,10,4,3,8,9};
        int ans = new Solution().lengthOfLIS(arr);
        System.out.println(ans);
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) return 0;
        int maxLen = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] > max) max = dp[j];
            }
            dp[i] = max + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}