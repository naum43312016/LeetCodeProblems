package naum.asafov.com.combinations;

import java.util.ArrayList;
import java.util.List;

/*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Main {
    public static void main(String[] args) {
        int n = 2,k=2;
        List<List<Integer>> list = new Solution().combine(n,k);
        System.out.println(list.toString());


    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combine(n, k, new List[n + 1][k + 1]);
    }

    public List<List<Integer>> combine(int n, int k, List<List<Integer>>[][] h) {


        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        //1://n=2 k=1
        //2
        for (int i = n; i >= k; i--) {
            if (h[i - 1][k - 1] == null) {
                h[i - 1][k - 1] = combine(i - 1, k - 1, h);
            }

            for (List<Integer> l : h[i - 1][k - 1]) {
                List<Integer> temp = new ArrayList<>(l);
                temp.add(i);
                result.add(temp);
            }
        }
        return result;

    }
}