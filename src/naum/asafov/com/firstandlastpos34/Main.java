package naum.asafov.com.firstandlastpos34;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int t = 2;
        int[] answer =  new Solution().searchRange(nums,t);
        System.out.println(Arrays.toString(answer));
    }
}
/*
[5,7,7,8,8,10]
6
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null){
            return new int[]{-1, -1};
        }
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        if (nums.length == 1){
            if (nums[0] == target){
                return new int[]{0,0};
            }
        }
        int[] a = new int[2];
        int b = Arrays.binarySearch(nums,target);
        if (b<0){
            return new int[]{-1, -1};
        }
        int start = b;
        int end = b;

        int w = b;
        while (w>=0 && w<nums.length && nums[w] == target){
            start = w;
            w--;
        }
        w = b;
        while (w>=0 && w<nums.length && nums[w] == target){
            end = w;
            w++;
            System.out.println(w);
        }
        a[0] = start;
        a[1] = end;
        if (start<0 || end>=nums.length){
            return new int[]{-1,-1};
        }
        return a;
    }
}