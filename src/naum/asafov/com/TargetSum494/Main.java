package naum.asafov.com.TargetSum494;
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int s = 3;
        int res = new Solution().findTargetSumWays(arr,s);
        System.out.println("Answer is:" + res);
    }
}
class Solution {
    private int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums==null || nums.length==0){
            return 0;
        }
        helper(nums,0,0,S);
        return res;
    }
    private void helper(int[] nums,int i,int sum,int s){
        if (i==nums.length){
            if (sum==s){
                res++;
            }
            return;
        }

        helper(nums,i+1,sum+nums[i],s);
        helper(nums,i+1,sum+(0-nums[i]),s);
    }
}