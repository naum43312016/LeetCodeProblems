package naum.asafov.com.subsets78;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Main {//sam
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> lists = new Solution().subsets(nums);
        System.out.println(lists.toString());
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        sub(nums,result,0,new ArrayList<>());
        result.add(new ArrayList<>());
        return result;
    }

    private List<Integer> sub(int[] nums,List<List<Integer>> result,int i,List<Integer> temp){
        for (;i<nums.length;i++){
            temp.add(nums[i]);
            for (int j = i+1;j<nums.length;j++){
                temp.add(nums[j]);
                sub(nums,result,j+1,temp);
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }

        return temp;
    }
}