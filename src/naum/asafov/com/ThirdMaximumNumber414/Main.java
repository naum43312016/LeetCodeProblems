package naum.asafov.com.ThirdMaximumNumber414;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1};
        int ans = new Solution().thirdMax(arr);
        System.out.println("Answer = " + ans);
    }
}
class Solution {
    public int thirdMax(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        if (nums.length <3){
            return nums[nums.length-1];
        }

        int c=3;
        int j = nums.length-1;
        while (c>1 && j>0){
            if (nums[j] !=nums[j-1]){
                c--;
                j--;
            }else {
                j--;
            }
        }
        if (j<0){
            return nums[nums.length-1];
        }
        return nums[j];
    }
}