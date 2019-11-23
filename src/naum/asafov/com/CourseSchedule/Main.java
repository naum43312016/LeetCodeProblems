package naum.asafov.com.CourseSchedule;

import java.util.*;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

 */
public class Main {

    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return numCourses >= 0;
        boolean[] visited = new boolean[numCourses];
        int n = prerequisites.length;
        int m = prerequisites[0].length;
        Map<Integer, List<Integer>> inverseAdjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = inverseAdjList.get(prerequisites[i][0]);
            if (list == null) list = new LinkedList<>();
            list.add(prerequisites[i][1]);
            inverseAdjList.put(prerequisites[i][0], list);
        }
        try {
            Set<Integer> trace = new HashSet<>((int)(1.5 * numCourses));
            List<Integer> finished = new ArrayList<>(numCourses);
            for (Integer index : inverseAdjList.keySet()) {
                if (!visited[index]) {
                    dfs(index, visited, trace, finished, inverseAdjList);
                    visited[index] = true;
                }
            }
            return finished.size() <= numCourses;
        } catch(Exception e) {
            return false;
        }
    }

    private void dfs(Integer index, boolean[] visited, Set<Integer> trace,
                     List<Integer> finished, Map<Integer, List<Integer>> inverseAdjList) {
        if (!trace.add(index)) throw new IllegalStateException("Exists Dead Loop");
        List<Integer> list = inverseAdjList.get(index);
        if (list != null) {
            for (Integer i : list) {
                if (!visited[i]) {
                    dfs(i, visited, trace, finished, inverseAdjList);
                    visited[i] = true;
                }
            }
        }
        finished.add(index);
    }
}