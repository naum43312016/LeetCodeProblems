package naum.asafov.com.BestTimetoBuyandSellStockIII123;

import java.util.*;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

***Max two transactions
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        int a = new Solution().maxProfit(arr);
        System.out.println("Answer is:"+a);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2)
            return 0;
        int[] profit = new int[n];

        int min = prices[0];
        int maxProfit = 0;
        for(int i=1; i<n; i++){
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
            profit[i] = maxProfit;
        }

        int max = prices[n-1];
        maxProfit = profit[n-1];
        for(int i=n-2; i>=0; i--){
            maxProfit = Math.max(maxProfit,max-prices[i]+profit[i]);
        }
        return maxProfit;
    }
}