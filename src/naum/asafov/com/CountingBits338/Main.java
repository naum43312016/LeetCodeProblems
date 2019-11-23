package naum.asafov.com.CountingBits338;

import java.util.Arrays;

/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]

 */
public class Main {
    public static void main(String[] args) {
        int[] ans = new Solution().countBits(5);
        System.out.println(Arrays.toString(ans));
    }
}
class Solution {

    public int[] countBits(int num) {
        int[] res = new int[num+1];
        String temp;
        for (int i=0;i<=num;i++){
            temp = Integer.toBinaryString(i);
            for (int j=0;j<temp.length();j++){
                if (temp.charAt(j)=='1') res[i]=res[i]+1;
            }
        }
        return res;
    }
}