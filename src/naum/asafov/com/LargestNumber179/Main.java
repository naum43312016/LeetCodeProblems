package naum.asafov.com.LargestNumber179;

import java.util.Arrays;
import java.util.Random;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.


 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {3,2};
        //int[] a = {3,2,4,5,20};
        //int[] a = {30,21,42};
        String s = new Solution().largestNumber(arr);
        System.out.println(s);



    }

}


class Solution {
    public String largestNumber(int[] nums) {
        // sort
        String[] sarray = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sarray[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(sarray, (a, b) -> (b+a).compareTo(a+b));
        System.out.println(Arrays.toString(sarray));
        // corner case
        if(sarray[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : sarray) {
            sb.append(s);
        }
        return sb.toString();
    }
}