package naum.asafov.com.rotatearray;

import java.util.Arrays;

/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
*/
public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        arr[0] = new int[]{1,2,3,4};
        arr[1] = new int[]{5,6,7,8};
        arr[2] = new int[]{9,10,11,12};
        arr[3] = new int[]{13,14,15,16};
        for (int i=0;i<arr.length;i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("********");
        new Solution().rotate(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
class Solution {
    public void rotate(int[][] matrix) {

        if (matrix.length%2!=0){

            for (int i = matrix.length - 1; i >0; i--) {
                int count = 0;
                for (int j = 0; j <matrix.length-1; j++) {
                    int z = j;
                    int k = i;
                    count = 0;
                    while (count<matrix.length){
                        if (z >= matrix.length-1 || k <1){

                            z=j;
                            k=i;
                        }
                        int temp = matrix[k][z];
                        matrix[k][z] = matrix[--k][++z];
                        matrix[k][z] = temp;
                        count++;
                    }
                }
            }

            //odd
            //take center el
            int x = matrix.length/2;
            int temp = matrix[x][x];
            matrix[x][x] = matrix[x-1][x+1];
            matrix[x-1][x+1] = temp;
        }






        //pomenat mestami
        for (int z = 0;z<matrix.length;z++){
            for (int y =matrix.length-1,j=0;y>=j;y--,j++){
                int temp = matrix[z][j];
                matrix[z][j] = matrix[z][y];
                matrix[z][y] = temp;
            }
        }
    }
}
