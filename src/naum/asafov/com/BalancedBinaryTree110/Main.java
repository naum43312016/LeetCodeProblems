package naum.asafov.com.BalancedBinaryTree110;


/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
 */

public class Main {
    public static void main(String[] args) {
        TreeNode t =new TreeNode(1);
        t.right = new TreeNode(2);
        t.left = new TreeNode(4);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(3);
        boolean a = new Solution().isBalanced(t);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (1 + Math.max(getHeight(root.right), getHeight(root.left)));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int rHeight = getHeight(root.right);
        int lHeight = getHeight(root.left);
        return ((Math.abs(rHeight - lHeight) <= 1) && isBalanced(root.right) && isBalanced(root.left));
    }
}