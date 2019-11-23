package naum.asafov.com.MajorityElement169;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

 */
public class Main {
    public static void main(String[] args) {
        int[] i ={3,2,3};
        new Solution().majorityElement(i);
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);

        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map.Entry<Integer, Integer> b = list.get(0);
        int a =b.getKey();
        return a;
    }
}
