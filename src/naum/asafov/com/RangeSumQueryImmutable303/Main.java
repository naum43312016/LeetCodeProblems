package naum.asafov.com.RangeSumQueryImmutable303;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArray n = new NumArray(arr);
        System.out.println(n.sumRange(2,5));
    }
}

class NumArray {

    private int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
    }

    public int sumRange(int i, int j) {
        int res = 0;
        while (i<=j){
            res+=arr[i++];
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */