package naum.asafov.com.Searcha2DMatrix74;

import java.util.Arrays;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

 */
public class Main {
    public static void main(String[] args) {
        int[][] arr ={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        boolean ans = new Solution().searchMatrix(arr,8);
        System.out.println("Answer is:"+ans);
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length ==0){
            return false;
        }
        for (int i=0;i<matrix.length;i++){
            if (matrix[i].length==0 || matrix[i]==null){
                continue;
            }
                if (target <= matrix[i][matrix[0].length-1]) {
                    int ans = Arrays.binarySearch(matrix[i], target);
                    if (ans >= 0) {
                        return true;
                    }
                }
        }
        return false;
    }
}