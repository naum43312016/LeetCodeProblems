package naum.asafov.com.maxsubarray;

public class Main {
    public static void main(String[] args) {
        //int[] nums = {31,-41,59,26,-53,58,97,-93,-23,84};
        int[] nums = {-5,8,-5,1,1,-3,5,5,-3,-3,6,4,-7,-4,-8,0,-1,-6};
        int a = new Solution().maxSubArray(nums);
        System.out.println(a);
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null){
            return -1;
        }
        if (nums.length==1){
            return nums[0];
        }

        int max = nums[0];
        int sum = Integer.MIN_VALUE;


        for (int i=0;i<nums.length;i++){
            max = nums[i];
            if (max>sum){
                sum=max;
            }
            if (max<=0){
                continue;
            }
            int sub = 0;
            int j = i+1;

            for (;j<nums.length;j++){
                sub+=nums[j];

                if (sub + nums[i] < 0){
                    if (max > sum){
                        sum = max;
                    }
                    break;
                }else {
                    max+=nums[j];
                    if (max > sum){
                        sum = max;
                    }
                }
            }
            i = j - 1;
        }


        return sum;
    }
}
