package naum.asafov.com.PartitionEqualSubsetSum416;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.


Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        //int[] arr = {23,13,11,7,6,5,5};//70=35
        System.out.println(new Solution().canPartition(arr));
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length<=1)
            return false;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(sum%2!=0)
            return false;

        int subsetSum = sum/2;

        boolean[][] dp = new boolean[nums.length+1][subsetSum+1];

        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=subsetSum;j++){
                if(j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[i][j]=false;
                else if(j<nums[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=(dp[i-1][j] || dp[i-1][j-nums[i-1]]);
            }
        }

        return dp[nums.length][subsetSum];
    }
}