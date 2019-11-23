package naum.asafov.com.FindAllDuplicatesinanArray442;

import java.util.ArrayList;
import java.util.List;
/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> list = new Solution().findDuplicates(arr);
        System.out.println(list.toString());
    }
}

class Solution {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> findDuplicates(int[] nums) {
/*
[4,3,2,7,8,2,3,1]
7,3,2,4,8,2,3,1
3,3,2,4,8,2,7,1
2,3,3,4,8,2,7,1
3,2,3,4,8,2,7,1
779,2,779,4,8,2,7,1
*,2,*,4,1,2,7,8
1,2,*,4,*,2,7,8
1,*,*,4,*,*,7,8
 */
        int i = 0;
        while (i<nums.length){
            if (nums[i]>nums.length){
                i++;
            }else {
                if (i==nums[i]-1){
                    i++;
                }else if (nums[i]==nums[nums[i]-1]){
                    list.add(nums[i]);
                    nums[nums[i]-1] = nums.length+1;
                    nums[i] = nums.length+1;
                }else {
                    swap(nums,i,nums[i]-1);
                }
            }
        }


        return list;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}