package naum.asafov.com.BinaryTreePreorderTraversal144;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Root, Left, Right
 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.left = new TreeNode(3);
        List<Integer> list = new Solution().preorderTraversal(t);
        System.out.println(list.toString());
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null){
            return list;
        }

        helper(root);

        return list;
    }

    private void helper(TreeNode node){
        if (node==null){
            return;
        }

        list.add(node.val);
        helper(node.left);
        helper(node.right);

    }
}