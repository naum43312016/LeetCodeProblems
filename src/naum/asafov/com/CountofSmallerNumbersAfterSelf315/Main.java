package naum.asafov.com.CountofSmallerNumbersAfterSelf315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        //int[] t = Arrays.copyOfRange(arr,1,arr.length);
        //System.out.println(Arrays.toString(t));
        System.out.println(new Solution().countSmaller(arr));
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums==null || nums.length==0){
            return list;
        }
        for (int i=0;i<nums.length-1;i++){
            int[] t = Arrays.copyOfRange(nums,i+1,nums.length+1);
            t[t.length-1] = nums[i];
            //int[] temp = s.sort(t,0,t.length-1);
            int temp = part(t,0,t.length-1);
            list.add(temp);
        }
        list.add(0);
        return list;
    }
    public int part(int arr[],int low,int high){
        int pivot = arr[high];
        int i = low-1;

        for (int j =low;j<high;j++){

            if (arr[j]<pivot){
                i++;


            }
        }
        return i+1;
    }

}