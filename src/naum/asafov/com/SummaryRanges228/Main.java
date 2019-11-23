package naum.asafov.com.SummaryRanges228;
/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0,2,3,4,6,8,9};
        List<String> list = new Solution().summaryRanges(arr);
        System.out.println(list.toString());
    }
}

class Solution {
    List<String> list = new ArrayList<>();
    public List<String> summaryRanges(int[] nums) {
        if (nums==null || nums.length==0){
            return list;
        }

        for (int i=0;i<nums.length;i++){
            StringBuilder str = new StringBuilder();
            str.append(nums[i]);
            String s = "";
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]-nums[i]==1){
                    s = String.valueOf(nums[j]);
                    i=j;
                }else {

                    break;
                }

            }
            if (s.length()>0){
                str.append("->");
                str.append(s);
            }
            list.add(str.toString());
        }
        return list;
    }
}