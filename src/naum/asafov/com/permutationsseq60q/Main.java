package naum.asafov.com.permutationsseq60q;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        String str = new Solution().getPermutation(4,9);
        System.out.println(str);
       // System.out.println(list.toString());

    }
}
class Solution {

    // intialize the elements for permutation
    List<Integer> elements = new ArrayList<>();
    // initialize the factorial
    int[] factorial;
    // result
    StringBuilder res = new StringBuilder();

    public String getPermutation(int n, int k) {

        // Adding elements for permutations to array
        for( int i = 1; i <= n; i++ ) {
            elements.add(i);
        }

        // get the factorial solutions for i
        factorial = new int[n+1];
        factorial[0] = 1;
        for( int i = 1; i <= n; i++ ) {
            factorial[i] = factorial[i-1] * i;
        }

        // helper function is a recursion function which is to find the kth permutation in n!
        helper(k-1);

        return new String(res);
    }


    // helper function
    private void helper( int k ) {
        // the end condition of recursion function
        if( elements.size() == 0 ) {
            return;
        }

        int m = elements.size();

        int index = k / factorial[m-1];
        res.append(elements.get(index));
        elements.remove(index);

        helper(k-index*factorial[m-1]);
    }
}