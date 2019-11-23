package naum.asafov.com.LongestConsecutiveSequence128;

import java.util.*;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.
Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int a = new Solution().longestConsecutive(arr);
        System.out.println("Answer is:" + a);
    }
}

class Solution {//sa

    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums);


        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return 1;
        }
        int j = 0;
        int max = 0;
        int m = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]){
                max = Math.max(max,m);
                continue;
            }
            if (nums[i+1]-nums[i]==1){
                m++;
                max = Math.max(max,m);
            }else {
                max = Math.max(max,m);
                m=1;
            }
        }

        return max;
    }
}