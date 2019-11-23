package naum.asafov.com.RandomPickIndex398;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,3};
        LinkedList<Integer> list = new LinkedList<>();

        Solution solution = new Solution(nums);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
    }
}

class Solution {

    Map<Integer,LinkedList<Integer>> map = new HashMap<>();
    public Solution(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                LinkedList<Integer> l = map.get(nums[i]);
                l.add(i);
                map.put(nums[i],l);
            }else {
                LinkedList<Integer> l = new LinkedList<>();
                l.add(i);
                map.put(nums[i],l);
            }
        }
    }

    public int pick(int target) {
        LinkedList<Integer> l = map.get(target);
        int len = l.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(len);
        return l.get(randomInt);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */