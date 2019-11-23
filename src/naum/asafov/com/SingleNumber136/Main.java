package naum.asafov.com.SingleNumber136;

import java.util.Arrays;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

 */
public class Main {
    public static void main(String[] args) {
        int[] a = {17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6};
        int ans = new Solution().singleNumber(a);
        System.out.println(ans);
    }
}
//No sorting
class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }


        int k=0;
        for (int i =0;i<nums.length;i++){
            if (k!=i){
                if (nums[k]==nums[i]){
                    swap(nums,k+1,i);
                    k+=2;
                    i=k;
                }
            }
        }



        return nums[k];
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}

//With sorting
/*
class Solution {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 1 && nums[i] == nums[i+1]){
            i += 2;
        }
        return nums[i];
    }
}
 */
