package naum.asafov.com.CombinationSumIII216;

import java.util.ArrayList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>>  list = new Solution().combinationSum3(3,9);
        System.out.println(list.toString());
    }
}

class Solution {
    List<List<Integer>>  list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k<1||n<1){
            return list;
        }

        helper(new ArrayList<>(),0,k,n,1);

        return list;
    }
    private void helper(List<Integer> temp,int res,int k,int n,int i){
        if (temp.size()==k){

            if (res==n){
                list.add(new ArrayList<>(temp));
            }
            return;
        }

        for (;i<=9;i++){
            temp.add(i);
            helper(temp,res+i,k,n,i+1);
            temp.remove(temp.size()-1);
        }


    }
}