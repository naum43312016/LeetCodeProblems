package naum.asafov.com.KthLargestElementinanArray215;

import java.util.Arrays;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new Solution().findKthLargest(arr,k));
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums==null || nums.length==0){
            return -1;
        }

        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}