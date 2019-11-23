package naum.asafov.com.candidatenumbers;


/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

 */
import java.util.*;

/*
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
 */
public class Main {
    public static void main(String[] args) {
        int[] c = {7,3,2};
        int t = 7;
        List<List<Integer>> r = new Solution().combinationSum(c,t);
        /*List<List<Integer>> v = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(7);
        v.add(l);
        l = new ArrayList<>();
        l.add(25);
        l.add(27);
        v.add(l);*/
        System.out.println(r);
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp=new LinkedList<>();
        List<List<Integer>> all=new LinkedList<>();
        Arrays.sort(candidates);
        search(candidates , 0, target, 0, temp, all);
        return all;
    }
    public void search(int []candidates,int index,int target,int current,List<Integer> temp,List<List<Integer>> all) {
        if(index>=candidates.length)
            return ;
        if(current>=target) {
            if(current==target) {
                all.add(new LinkedList<>(temp));
            }
            return ;
        }else {
            for(int i=index;i<candidates.length;i++) {
                if(current+candidates[i]>target)
                    return ;
                temp.add(candidates[i]);
                search(candidates, i, target, current+candidates[i], temp, all);
                temp.remove(temp.size()-1);
                index++;
            }
        }
    }
}
