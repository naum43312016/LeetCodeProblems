package naum.asafov.com.editdistance;
/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */
/*
We can use Levenshtein Distance Algorithm
 */
public class Main {
    public static void main(String[] args) {
        int a = new Solution().minDistance("horse","");
        System.out.println(a);
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1==null || word2 ==null){
            return 0;
        }

        return levenstein(word1,word2);
    }
    private int levenstein(String x,String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }
    private int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
    private int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
}