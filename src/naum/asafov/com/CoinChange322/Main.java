package naum.asafov.com.CoinChange322;

import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {2};
        int a = 3;
        int min = new Solution().coinChange(arr,a);
        System.out.println("Minimum is:"+min);
    }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins); //sort first so we can use big coin first
        return helper(coins,coins.length-1,0,amount,Integer.MAX_VALUE);
    }

    int helper(int[] coins,int start,int count,int amount,int max){
        if(amount==0) //find one possible answer
            return count;
        if(start==-1) //not an answer
            return -1;
        int val = amount/coins[start];  //find the maximus number of coin we can use
        amount = amount-val*coins[start]; //remain amount
        while(val>=0&&count+val<max){
            int c = helper(coins,start-1,count+val,amount,max);
            if(c!=-1) //only use legal answer
                max = Math.min(c,max);
            val--;
            amount+=coins[start];
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}