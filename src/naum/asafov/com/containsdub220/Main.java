package naum.asafov.com.containsdub220;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 3;
        int i = 2147483647-1;
        System.out.println(i);
        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums,1,2147483647));
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for(int i = 0;i<nums.length;i++)
        {
            for(int j = i+1;j<=i+k && j < nums.length;j++)
            {
                if(Math.abs((long)nums[i]-nums[j]) <= t)
                    return true;
            }
        }

        return false;
    }
}