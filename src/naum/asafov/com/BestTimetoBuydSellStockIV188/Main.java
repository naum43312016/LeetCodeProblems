package naum.asafov.com.BestTimetoBuydSellStockIV188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {3,2,6,5,0,3};
        //int[] arr = {2,1,2,1,0,1,2};
        int a = new Solution().maxProfit(29,arr);
        System.out.println(a);
    }
}

class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n<2 || k<=0)
            return 0;

        if (k >=  n/2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxProfit += prices[i] - prices[i-1];
            }
            return maxProfit;
        }

        int[][] profit = new int[2][n];

        for(int i=1; i<=k; i++){
            int maxDiff = -prices[0];
            for(int j=1; j<n; j++){
                profit[1][j] = Math.max(profit[1][j-1], prices[j]+maxDiff);
                maxDiff = Math.max(maxDiff, profit[0][j] - prices[j]);
            }
            for(int x=1; x<n; x++){
                profit[0][x] = profit[1][x];
            }
        }

        return profit[1][n-1];
    }
}

