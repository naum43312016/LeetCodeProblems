package naum.asafov.com.ConvertSortedArraytoBinarySearchTree108;

import java.util.Arrays;
import java.util.Collections;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example:
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5
 */
/*
[5,8,10,15,14]

    10
   5  14
    8   15
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = new Solution().sortedArrayToBST(nums);
        System.out.println(root);
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

     @Override
     public String toString() {
         return "TreeNode{" +
                 "val=" + val +
                 ", left=" + left +
                 ", right=" + right +
                 '}';
     }
 }

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null || nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        TreeNode root = null;
        if(start > end)
            return null;
        else{
            int mid = (start + end) / 2;
            root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid - 1);
            root.right = sortedArrayToBST(nums, mid+1, end);
        }

        return root;
    }
}