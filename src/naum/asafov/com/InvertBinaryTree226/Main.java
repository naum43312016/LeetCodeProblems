package naum.asafov.com.InvertBinaryTree226;

import java.util.ArrayList;
import java.util.List;

/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        //t.right = new TreeNode(2);
       /* t.left.left = new TreeNode(9);
        t.left.right = new TreeNode(6);
        t.right.left = new TreeNode(3);
        t.right.right = new TreeNode(1);*/
        System.out.println(new Solution().invertTree(t));
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
    List<List<TreeNode>> list = new ArrayList<>();
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }

        helper(root);


        return root;
    }
    private void helper(TreeNode node){
        if (node==null){
            return;
        }

        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        helper(node.left);
        helper(node.right);
    }
}