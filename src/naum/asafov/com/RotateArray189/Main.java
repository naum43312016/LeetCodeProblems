package naum.asafov.com.RotateArray189;

import java.util.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 */
public class Main {
    public static void main(String[] args) {
        //int[] arr = {1,2,3,4,5,6};
        int[] arr = {-1,-100,3,99};
        //int[] arr = {1,2};
        int k = 2;//n7-4
        new Solution().rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length-1);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}