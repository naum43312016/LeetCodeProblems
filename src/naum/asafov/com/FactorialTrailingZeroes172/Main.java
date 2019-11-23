package naum.asafov.com.FactorialTrailingZeroes172;


/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.

 */
public class Main {
    public static void main(String[] args) {
        int k = 4;
        int m = new Solution().trailingZeroes(k);
        System.out.println(m);
    }
}
class Solution {
    public int trailingZeroes(int n) {
            if(n<5){
                return 0;
            }
            int res=0;
            while(n>=5){
                res+=n/5;
                n/=5;
            }
            return res;
    }
}
