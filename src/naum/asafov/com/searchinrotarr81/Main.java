package naum.asafov.com.searchinrotarr81;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums ={2,5,6,0,0,1,2};
        int target = 1;
        new Solution().search(nums,target);
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int a = Arrays.binarySearch(nums,target);
        if (a>=0) return true;
        return false;
    }
}