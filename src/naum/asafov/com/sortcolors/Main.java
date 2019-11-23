package naum.asafov.com.sortcolors;

import java.util.Arrays;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void sortColors(int[] nums) {
        if (nums==null){
            return;
        }
        if (nums.length==0){
            return;
        }
        int max = 2;
        int[] count = new int[max+1];
        for (int i =0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int j = 0;
        for (int i=0;i<count.length;i++){
            while (count[i] != 0){
                nums[j] = i;
                count[i]--;
                j++;
            }
        }
    }
}