package naum.asafov.com.perm2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> a = new Solution().permuteUnique(nums);
        System.out.println(a.toString());
    }
}
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (nums==null){
            return list;
        }
        backtrack(list,temp,nums,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> temp,int[] nums,int pos){
        if (pos==nums.length){
            if (list.contains(temp)){
                return;
            }else {
                list.add(new ArrayList<>(temp));
                return;
            }
        }

        for (int i = pos;i<nums.length;i++){
            swap(nums,i,pos);
            temp.add(nums[pos]);
            backtrack(list,temp,nums,pos+1);
            swap(nums,i,pos);
            temp.remove(temp.size()-1);
        }

    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
