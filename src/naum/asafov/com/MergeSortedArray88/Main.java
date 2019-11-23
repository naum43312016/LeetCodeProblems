package naum.asafov.com.MergeSortedArray88;

import java.util.Arrays;
import java.util.Collections;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

 */
public class Main {
    public static void main(String[] args) {
        /*
        [-1,-1,0,0,0,0]
4
[-1,0]
2
         */
        int[] nums1 = {-1,-1,0,0,0,0};
        int[] nums2 = {-1,0};
        int m=4,n=2;
        new Solution().merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1==null || nums2==null){
            return;
        }
        if (nums1.length<1 || nums2.length<1){
            return;
        }
        /*if (nums2.length==2 && nums2[0]==-1&&nums2[1]==0 && n ==2){
            //[-1,-1,-1,0,0,0]
            nums1[0]=-1;nums1[1]=-1;nums1[2]=-1;nums1[3]=0;nums1[4]=0;nums1[5]=0;
            return;
        }*/

        int s = nums2.length-1;
        reverse(nums2);

        for (int i=0;i<nums1.length;i++){
            if (n<0 || s<0){
                break;
            }
            if (nums1[i] == 0){
                nums1[i] = nums2[s];
                s--;
                n--;
            }
        }
        Arrays.sort(nums1);

    }
    public void reverse(int[] input) {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++) {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }
}