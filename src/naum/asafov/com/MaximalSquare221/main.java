package naum.asafov.com.MaximalSquare221;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

 */
public class main {
    public static void main(String[] args) {
        char[][] arr = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };




        int i = new Solution().maximalSquare(arr);

    }
}
class Solution {
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] edgeArray = new int[matrix.length][matrix[0].length];
        int maxEdge = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    edgeArray[i][j] = matrix[i][j] == '0'? 0 : 1;
                } else if (matrix[i][j] == '1') {
                    edgeArray[i][j] = Math.min(Math.min(edgeArray[i-1][j-1], edgeArray[i][j-1]), edgeArray[i-1][j]) + 1;
                }
                maxEdge = Math.max(maxEdge, edgeArray[i][j]);
            }
        }
        return maxEdge * maxEdge;
    }
}