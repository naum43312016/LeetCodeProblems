package naum.asafov.com.TopKFrequentElements347;

import java.util.*;
import java.util.stream.Collectors;

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1};
        List<Integer> list = new Solution().topKFrequent(arr,1);
        System.out.println(list.toString());
    }
}
class Solution {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums==null || nums.length==0){
            return res;
        }
        if (nums.length==1){
            res.add(nums[0]);
            return res;
        }


        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }

        Map<Integer,Integer> top =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(k)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        res.addAll(top.keySet());
        return res;
    }
}