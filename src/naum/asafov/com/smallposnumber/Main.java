package naum.asafov.com.smallposnumber;

import java.util.Arrays;

/*
HARD
Runtime: 1 ms, faster than 36.20% of Java online submissions for First Missing Positive.

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
самый маленькое положительное число,которого не хватает в массиве.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,4,1,0};
        int a = new Solution().firstMissingPositive(nums);
        System.out.println(a);
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for (int i =0;i<nums.length;i++){
            if (nums[i]>-1){
                return find(nums,i,nums.length-1);
            }
        }
        return 1;
    }
    int find(int[] nums,int left,int right){
        if (nums[left]>1){
            return 1;
        }
        while (left<right){
            if ((nums[left] + 1) < nums[left+1] ){
                return nums[left] + 1;
            }
            left++;
        }

        return nums[right]+1;
    }
}