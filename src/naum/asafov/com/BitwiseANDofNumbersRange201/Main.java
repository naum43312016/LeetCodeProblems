package naum.asafov.com.BitwiseANDofNumbersRange201;
/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

5=101 6 = 110;7=111

Input: [0,1]
Output: 0



 */
public class Main {
    public static void main(String[] args) {
        int i =3,y=2828;


        int a = i&y;
        System.out.println(a);
        //System.out.println(new Solution().rangeBitwiseAnd(5,7));
    }
}

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m==0){
            return 0;
        }

        int ans = m;
        for (int i=m+1;i<=n;i++){
            ans&=i;
        }
        return ans;
    }
}