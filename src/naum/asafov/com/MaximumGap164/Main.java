package naum.asafov.com.MaximumGap164;

import java.util.Arrays;

/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maximumGap(int[] nums) {
        int max = 0;
        if (nums==null || nums.length<2){
            return 0;
        }

        Arrays.sort(nums);

        for (int i=0;i<nums.length-1;i++){
            max = Math.max(max,nums[i+1]-nums[i]);
        }

        return max;
    }
}