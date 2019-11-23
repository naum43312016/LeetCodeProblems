package naum.asafov.com.SingleNumberIII260;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        int[] ans = new Solution().singleNumber(arr);
        System.out.println(ans[0]+"::"+ans[1]);
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int k=0;
        if (nums==null || nums.length==0){
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++){
            if (i==nums.length-1){
                res[k]=nums[i];
            }else {
                if (nums[i]!=nums[i+1]){
                    res[k] = nums[i];
                    k++;
                }else {
                    i++;
                }
            }
        }
        return res;
    }
}