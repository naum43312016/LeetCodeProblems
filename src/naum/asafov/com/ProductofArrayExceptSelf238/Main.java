package naum.asafov.com.ProductofArrayExceptSelf238;

import java.util.List;

/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Solution s = new Solution();
        int[] res = s.productExceptSelf(arr);
        for (int i : res){
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < result.length; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }

        int nextSum = nums[result.length - 1];
        for(int i = result.length - 2; i >=0; i--){
            result[i] = result[i] * nextSum;
            nextSum = nextSum * nums[i];
        }

        return result;

    }
}