package naum.asafov.com.RangeSumQuery2DImmutable304;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix n = new NumMatrix(arr);
        System.out.println(n.sumRegion(2,1,4,3));
    }
}

class NumMatrix {

    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        while (row1<=row2){
            int i= col1;
            while (i<=col2){
                res+=matrix[row1][i];
                i++;
            }
            row1++;
        }

        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */