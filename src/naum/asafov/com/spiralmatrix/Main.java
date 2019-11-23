package naum.asafov.com.spiralmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] mat = new int[3][4];
        //System.out.println(mat[0].length);
        mat[0] = null;
        for (int[] m:mat) {
            System.out.println(Arrays.toString(m));
        }
    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length < 1) return ans;

        int j = 0;
        int k = 0;

        // Initiate 4 booleans to decide our next move
        boolean right = true, left = false, down = false, up = false;

        // Initiate 4 ints to count and calculate the range of the cursor
        int downTime = 0, leftTime = 0, upTime = 0, rightTime = 0;
        while(true) {
            if(ans.size() == matrix.length * matrix[0].length) return ans;

            //The cursor is turning right
            if(right) {
                for(j = upTime; j < matrix[0].length - downTime; j++) {
                    ans.add(matrix[downTime][j]);
                }
                right = false;
                down = true; //turn down after turning right
                rightTime++;
                j--;
            }

            //The cursor is turning down
            else if(down) {
                for(k = rightTime; k < matrix.length - leftTime; k++) {
                    ans.add(matrix[k][j]);
                }
                down = false;
                left = true; //turn left after turning down
                downTime++;
                k--;
                j--; //j-- to ensure no duplicate element next turn
            }

            //The cursor is turning left
            else if(left) {
                for(; j >= upTime; j--) {
                    ans.add(matrix[k][j]);
                }
                left = false;
                up = true; //turn up after turning left
                leftTime++;
                j++;
                k--; //k-- to ensure no duplicate element next turn
            }

            //The cursor is turning up
            else if(up) {
                for(; k >= rightTime; k--) {
                    ans.add(matrix[k][j]);
                }
                up = false;
                right = true; //turn right after turning up
                upTime++;
            }
        }
    }
}
