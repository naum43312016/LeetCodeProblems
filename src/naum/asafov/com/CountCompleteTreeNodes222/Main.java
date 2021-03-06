package naum.asafov.com.CountCompleteTreeNodes222;
/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
 */
public class Main {
    public static void main(String[] args) {
        TreeNode t =new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        int c = new Solution().countNodes(t);
        System.out.println(c);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    int count = 0;
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        helper(root);
        return count;
    }
    private void helper(TreeNode node){
        if (node==null) return;

        count++;
        helper(node.left);
        helper(node.right);
    }
}