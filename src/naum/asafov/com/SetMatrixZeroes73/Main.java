package naum.asafov.com.SetMatrixZeroes73;

import java.util.Arrays;
/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
Example 1:
Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

We need constant space solution
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        new Solution().setZeroes(arr);
        for (int[] a:arr){
            System.out.println(Arrays.toString(a));
        }
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix==null){
            return;
        }
        if (matrix.length==0){
            return;
        }

        recursion(matrix,0,0);
    }

    //m=column,n=row
    private void recursion(int[][] matrix,int m,int n){

        if (m>=matrix.length || n >=matrix[0].length){
            return;
        }
        boolean flag = false;
        if (matrix[m][n] == 0){
            flag = true;
        }
        if (n==matrix[0].length-1){
            recursion(matrix,m+1,0);
        }else {
            recursion(matrix,m,n+1);
        }
        if (flag){
            System.out.println("m="+m+": n="+n);
            for (int i = 0;i<matrix[0].length;i++){
                matrix[m][i] = 0;
            }
            for (int j = 0;j<matrix.length;j++){
                matrix[j][n] = 0;
            }
        }
    }
}
