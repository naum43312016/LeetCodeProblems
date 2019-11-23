package naum.asafov.com.HappyNumber202;
/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

 */

import java.util.HashSet;
import java.util.Set;

/*
11
1^+1=2
4
16
 */
public class Main {
    public static void main(String[] args) {


        int i = 17;
        System.out.println(new Solution().isHappy(i));
    }
}

class Solution {
    HashSet set = new HashSet<>();
    public boolean isHappy(int n) {
        set.add(n);
        if (n == 1) {
            return true;
        }
        int ans = 0;
        int temp = 0;

        while (n > 0) {
            temp = n % 10;

            ans = ans + (temp * temp);

            n = n / 10;
        }
        if (set.contains(ans)) {
            return false;
        }
        set.add(ans);
        return isHappy(ans);

    }
}
