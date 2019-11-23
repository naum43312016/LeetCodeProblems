package naum.asafov.com.insertintervale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(6);
        lists.add(l);
        int[][] arr = {
                {1,3},{6,9}
        };


        int[] n = {2,5};


        int[][] ans = new Solution().insert(arr,n);
        for (int i=0;i<ans.length;i++){
            System.out.println("I="+i);
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr2 = Arrays.copyOf(intervals,intervals.length+1);
        arr2[arr2.length-1] = newInterval;
        return merge(arr2);

    }
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][0];

        Arrays.sort(intervals, (Comparator.comparingInt(x -> x[0])));

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