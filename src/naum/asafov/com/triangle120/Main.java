package naum.asafov.com.triangle120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).


 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(){
            {add(2);}
        });
        triangle.add(new ArrayList<>(){
            {add(3);add(4);}
        });
        triangle.add(new ArrayList<>(){
            {add(6);add(5);add(7);}
        });
        triangle.add(new ArrayList<>(){
            {add(22);add(10);add(8);add(17);}
        });


        int a = new Solution().minimumTotal(triangle);
        System.out.println("Answer:" + a);

    }
}

//Iterative Solution
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] aux = triangle.get(size - 1).stream().mapToInt(i -> i).toArray();
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                aux[j] = Math.min(aux[j], aux[j + 1]) + triangle.get(i).get(j);
            }
        }
        return aux[0];
    }
}


//Recursive Solution
//class Solution {
//    int min = Integer.MAX_VALUE;
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle==null || triangle.size()<1){
//            return 0;
//        }
//        if (triangle.size()==1){
//            return triangle.get(0).get(0);
//        }
//
//        helper(triangle,0,0,0);
//
//        return min;
//    }
//
//    private void helper(List<List<Integer>> triangle,int col,int row,int res){
//        if (col==triangle.size()-1){
//            res+=triangle.get(col).get(row);
//            min = Math.min(res,min);
//            return;
//        }
//
//        if (row==triangle.get(col).size()){
//            return;
//        }
//
//
//        res+=triangle.get(col).get(row);
//
//        helper(triangle,col+1,row,res);
//        helper(triangle,col+1,row+1,res);
//
//
//    }
//}