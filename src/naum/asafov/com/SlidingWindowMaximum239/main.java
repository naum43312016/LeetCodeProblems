package naum.asafov.com.SlidingWindowMaximum239;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.


 */
public class main {
    public static void main(String[] args) {
        int[] arr = {1,-1};
        int[] a = new Solution().maxSlidingWindow(arr,1);
        for (int i :a){
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i =0;i<nums.length;i++){
            max = nums[i];
            if ((i+k)>nums.length){

                i=nums.length;
            }else {
                for (int j=i;j<i+k;j++){
                    max=Math.max(max,nums[j]);
                }
                list.add(max);
            }

        }
        /*for (int i =0;i<nums.length;i++){
            if (i==0){
                for (int j=0;j<k;j++){
                    max=Math.max(max,nums[j]);
                }
            }else {
                if (i+k-1>=nums.length-1 && k>1){
                    if (max==nums[i-1]){
                        max = Math.max(nums[i],nums[i+1]);
                    }
                    max = Math.max(max,nums[nums.length-1]);
                    i=nums.length;
                }else if (k==1){
                    max = nums[i];
                }else {
                    if (max==nums[i-1]){
                        max = Math.max(nums[i],nums[i+1]);
                    }
                    max = Math.max(max,nums[i+k-1]);
                }
            }

            list.add(max);
        }*/

        int[] array = list.stream().mapToInt(i->i).toArray();
        return array;
    }
}