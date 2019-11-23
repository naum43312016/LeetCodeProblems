package naum.asafov.com.RangeSumQueryMutable307;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

 */
public class Main {
    public static void main(String[] args) {

    }
}
class NumArray {
    private int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
    }

    public void update(int i, int val) {
        arr[i] = val;
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
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */