package naum.asafov.com.MaximalRectangle85;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
Example:
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */
public class Main {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1','0','1','0','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };//10

        /*
        [["1","0","1","1","0","1"],["1","1","1","1","1","1"]
        ,["0","1","1","0","1","1"],["1","1","1","0","1","0"],
        ["0","1","1","1","1","1"],["1","1","0","1","1","1"]]
         */
       char[][] arr2 = new char[][]{
                {'1','0','1','1','0','1'},
                {'1','1','1','1','1','1'},
                {'0','1','1','0','1','1'},
                {'1','1','1','0','1','0'},
                {'0','1','1','1','1','1'},
                {'1','1','0','1','1','1'}

        };

        int a = new Solution().maximalRectangle(arr2);
        System.out.println(a);
    }
}
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxSize = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == '1') {
                    int size = calcRectSize(matrix, i, j);
                    maxSize = Math.max(size, maxSize);
                }
            }
        }
        return maxSize;
    }

    private int calcRectSize(char[][] matrix, int row, int col) {
        int maxSize = 0;
        int minColSize = Integer.MAX_VALUE;
        for (int i = row; i < matrix.length && matrix[i][col] == '1'; ++i) {
            int colSize = 0;
            for (int j = col; j < matrix[i].length && matrix[i][j] == '1'; ++j) {
                colSize++;
            }
            minColSize = Math.min(minColSize, colSize);
            maxSize = Math.max((i - row + 1) * minColSize, maxSize);
        }
        return maxSize;
    }
}

