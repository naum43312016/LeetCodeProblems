package naum.asafov.com.RemoveDuplicatesfromArrayII80;

import java.util.Arrays;

/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.

 */
public class Main {
    public static void main(String[] args) {
        int[] nums ={1,1,1,2,2,3};
        int len = new Solution().removeDuplicates(nums);
        if (len>0) {
            for (int i = 0; i <len; i++) {
                System.out.println(nums[i]);
            }
        }
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length<1){
            return 0;
        }
        if (nums.length==1){
            return 1;
        }
        int len = nums.length;
        for (int i = 0;i<len;i++){

            int j = i+2;
            if (j<nums.length) {
                while (nums[i] == nums[j]) {
                    shift(nums, j);
                    len--;
                }
            }
        }

        return len;
    }

    private void shift(int[] nums,int i){
        int len = nums.length-1;
        nums[i] = -1;
        while (i<=len){
            //swap
            int temp = nums[i];
            nums[i] = nums[len];
            nums[len] = temp;
            len--;
        }

    }
}