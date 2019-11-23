package naum.asafov.com.MaximumProductSubarray152;
/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
ymnojenie
Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int ans = new Solution().maxProduct(nums);
        System.out.println(ans);
    }
}

class Solution {
    int max = 0;
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }

        for (int i =0;i<nums.length;i++){
            int res = nums[i];
            if (res>max) max = res;
            for (int j =i+1;j<nums.length;j++){
                if (res==0) break;
                res*=nums[j];
                if (res>max) max = res;
            }
        }

        return max;
    }
}