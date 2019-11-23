package naum.asafov.com.jump;

public class Main {
    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.


Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

     */
    public static void main(String[] args) {
        int[] nums = {2,2,3,1,4};
        int a = new Solution().jump(nums);
        System.out.println("Jumps = " + a);
    }
}
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        return minJump(nums);
    }

    private int minJump(int[] nums) {
        int jump = 1;
        int curIdx = 0;
        int nextIdx = curIdx;
        while (true) {
            if(nums[curIdx] + curIdx < nums.length - 1) {
                int maxDis = 0;
                for (int j = 1; j <= nums[curIdx]; j++) {
                    if (nums[curIdx + j] + curIdx + j > maxDis) {
                        maxDis = nums[curIdx + j] + curIdx + j;
                        nextIdx = curIdx + j;
                    }
                }
                curIdx = nextIdx;
                jump++;
            } else {
                break;
            }
        }

        return jump;
    }
}