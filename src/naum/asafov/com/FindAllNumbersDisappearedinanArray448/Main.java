package naum.asafov.com.FindAllNumbersDisappearedinanArray448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for (int i=1;i<=nums.length;i++){
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}