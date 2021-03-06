package naum.asafov.com.Searcha2DMatrixII240;

import java.util.Arrays;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]

 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0){
            return false;
        }
        for (int[] arr : matrix){
            if (Arrays.binarySearch(arr,target) >0){
                return true;
            }
        }
        return false;
    }
}