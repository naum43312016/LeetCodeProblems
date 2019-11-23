package naum.asafov.com.PascalsTriangleII119;

import java.util.ArrayList;
import java.util.List;
/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> l = new Solution().getRow(-1);
        System.out.println(l.toString());
    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex<0 || rowIndex>33){
            return null;
        }
        List<List<Integer>> list = new Pas().generate(rowIndex+1);

        return list.get(rowIndex);
    }
}

class Pas {
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