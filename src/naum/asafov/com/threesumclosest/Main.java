package naum.asafov.com.threesumclosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) throw new Error("array length is less than 3");
        //sort the array
        Arrays.sort(nums);
        int retVal = 0, minDiff = Integer.MAX_VALUE;
        int j, k;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return sum;
                else if (sum < target) j++;
                else k--;
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    retVal = sum;
                }
                System.out.println("sum=" + sum);
            }
        }
        return retVal;
    }
}