package naum.asafov.com.PascalsTriangle118;

import java.util.ArrayList;
import java.util.List;
/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.
Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class Main {
    public static void main(String[] args) {
        int i =5;
        List<List<Integer>> l = new Solution().generate(i);
        System.out.println(l.toString());
    }
}

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        if(numRows<1){
            return list;
        }
        if (numRows==1){
            List<Integer> t = new ArrayList<>();
            t.add(1);
            list.add(t);
            return list;
        }

        int i = numRows;
        while (i>0){
            list.add(new ArrayList<>());
            i--;
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);

        i=1;
        for (;i<list.size()-1;i++){
            list.get(i+1).add(1);
            int len = list.get(i).size();
            for (int j=0;j<len-1;j++){
                list.get(i+1).add(list.get(i).get(j) + list.get(i).get(j+1));
            }
            list.get(i+1).add(1);
        }

        return list;
    }
}