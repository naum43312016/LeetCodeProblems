package naum.asafov.com.SingleNumberII137;

import java.util.Arrays;

/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

 */
public class Main {
    public static void main(String[] args) {
        int[] n = {0,1,0,1,0,1,99};
        System.out.println(new Solution().singleNumber(n));
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 1 && nums[i] == nums[i+1]){
            i += 3;
        }
        return nums[i];
    }
}