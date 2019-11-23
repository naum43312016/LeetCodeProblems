package naum.asafov.com.MoveZeroes283;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        new Solution().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums!=null && nums.length>1){

            for (int i =0;i<nums.length;i++){
                if (nums[i]==0){
                    int j =i;
                    while (j<nums.length && nums[j]==0){
                        j++;
                    }
                    if (j< nums.length){
                        swap(i,j,nums);
                    }

                }
            }
        }
    }

    private void swap(int i, int k,int[] nums) {
        int t = nums[i];
        nums[i] = nums[k];
        nums[k] = t;
    }
}