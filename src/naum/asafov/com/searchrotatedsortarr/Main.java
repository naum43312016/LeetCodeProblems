package naum.asafov.com.searchrotatedsortarr;

public class Main {
    public static void main(String[] args) {

        //int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {1,3};
        int t = 2;
        int ans = new Solution().search(nums,t);
        System.out.println("Answer = "+ ans);
    }
}

//4

class Solution {
    public int search(int[] nums, int target) {

        if (nums==null){
            return -1;
        }
        if (nums.length==1){
            if (nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }
        if (nums.length==0){
            return -1;
        }


        return rotatedSearch(nums,target,0,nums.length-1);
    }

    int rotatedSearch(int[] nums,int target,int low,int high){
        while (low<high){
            if (nums[low]>target){
                low++;
            }
            if (nums[high]>target){
                high--;
            }
            if (nums[low]<target){
                low++;
            }
            if (nums[high]<target){
                high--;
            }
        }
        if (high<0){
            return -1;
        }
        if (low>nums.length-1){
            return -1;
        }
        if (nums[high] == target){
            return high;
        }else {
            return -1;
        }
    }
}
