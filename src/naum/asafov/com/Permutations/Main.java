package naum.asafov.com.Permutations;
/*
Given a collection of distinct integers, return all possible permutations.
Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = new Solution().permute(nums);
        System.out.println(list.toString());
    }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int pos) {
        if (pos == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            list.add(nums[pos]);
            backtrack(lists, list, nums, pos + 1);
            swap(nums, pos, i);
            list.remove(list.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}