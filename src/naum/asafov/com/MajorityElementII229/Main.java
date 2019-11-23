package naum.asafov.com.MajorityElementII229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,2,2,2};
        List<Integer> list = new Solution().majorityElement(arr);
        System.out.println(list.toString());
    }
}

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> majorityElement(int[] nums) {
        if (nums==null || nums.length<1){
            return list;
        }
        Arrays.sort(nums);
        int size = nums.length;
        int n = size/3;

        for (int i=0;i<nums.length;i++){
            int count = 1;
            for (int j = i+1;j<nums.length;j++){
                if (nums[j]==nums[i]){
                    count++;
                    i=j;
                }else {
                    break;
                }
            }
            if (count>n){
                list.add(nums[i]);
            }
        }
        return list;
    }
}