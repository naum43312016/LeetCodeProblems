package naum.asafov.com.ShortestUnsortedContinuousSubarray581;

import java.util.Arrays;

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new Solution().findUnsortedSubarray(arr));
    }
}


class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int[] arr = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int c = nums.length;
        while (r>0 &&nums[r] == arr[r]){
            r--;
            c--;
        }
        while (l<nums.length && nums[l] == arr[l]){
            l++;
            c--;
        }
        if(c<0) return 0;
        return c;
    }
}