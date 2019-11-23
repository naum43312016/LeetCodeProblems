package naum.asafov.com.HouseRobber198;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        int m = new Solution().rob(a);
        System.out.println(m);
    }
}

class Solution {
    public int rob(int[] nums) {
        int numLen=nums.length;
        int[] sumValues=new int[numLen];
        if(numLen==0) return 0;
        if(numLen==1) return nums[0];
        if(numLen==2) return Math.max(nums[0],nums[1]);
        sumValues[0]=nums[0];
        sumValues[1]=Math.max(nums[1],nums[0]);
        for(int i=2;i<numLen;i++){

            sumValues[i]=Math.max(sumValues[i-2]+nums[i],sumValues[i-1]);;
        }

        return sumValues[numLen-1];
    }
}