package naum.asafov.com.MinimumSizeSubarraySum209;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]//nevajen index
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Input
11
[1,2,3,4,5]
ans=3 2+4+5
 */
public class Main {


    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int a = new Solution().minSubArrayLen(7,nums);
        System.out.println("Answer:"+a);
    }
}

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //result (set to highest value for now)
        int result = Integer.MAX_VALUE;
        //pointer to keep track of leftmost in subarray
        int left = 0;
        //to keep track of current sum (needs to be >= s)
        int currentSum = 0;
        //iterate through nums
        for (int i = 0; i < nums.length; i++) {
            //increment sum
            currentSum += nums[i];
            //if current sum is greater than or equal to S (our condition)
            while (currentSum >= s) {
                //current sum obviously meets condition, so we see if current subarray length
                //is less than current result
                if (i-left < result) result = (i+1) - left;
                //decrease distance (subarray length)
                currentSum -= nums[left];
                left++;
            }
        }
        //make sure we found a lower result than max value
        return (result != Integer.MAX_VALUE) ? result : 0;
    }
}