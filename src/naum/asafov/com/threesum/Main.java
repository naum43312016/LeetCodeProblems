package naum.asafov.com.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,5,-5,0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }

    static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length<3){
            return lists;
        }
        Arrays.sort(nums);
        int j,k,sum;
        for (int i = 0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            j=i+1;
            k = nums.length-1;
            //System.out.println("J="+j);
            sum = 0;
            while (j<k){
                sum = nums[i] + nums[j] + nums[k];

                if (sum == 0){

                    lists.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(j<k && nums[j] == nums[j-1]) j++;
                }else if (sum<0){
                    j++;
                }else {
                    k--;
                }
            }
        }

        return lists;
    }
}
