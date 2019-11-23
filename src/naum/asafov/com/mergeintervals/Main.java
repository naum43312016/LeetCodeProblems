package naum.asafov.com.mergeintervals;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(6);
        lists.add(l);
        int[][] arr = {
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] ans = new Solution().merge(arr);
        /*//3>=2 1&&3<6
        [[1,3],[2,6],[8,10],[15,18]]
         */
        //System.out.println(arr[0][2]);
        for (int i=0;i<ans.length;i++){
            System.out.println("I="+i);
            System.out.println(Arrays.toString(ans[i]));
        }

    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][0];

        System.out.println("In:"+intervals[0][0] + intervals[0][1]+intervals[1][0]+intervals[1][1]);
        Arrays.sort(intervals, (Comparator.comparingInt(x -> x[0])));
        System.out.println("In:"+intervals[0][0] + intervals[0][1]+intervals[1][0]+intervals[1][1]);

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0])
                current[1] = Math.max(current[1], intervals[i][1]);
            else {
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current);
        return merged.toArray(new int[0][0]);
    }
}