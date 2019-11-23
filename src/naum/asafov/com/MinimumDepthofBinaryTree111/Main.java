package naum.asafov.com.MinimumDepthofBinaryTree111;
/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.


 */
public class Main {
    public static void main(String[] args) {
        TreeNode t =new TreeNode(1);
        t.right = new TreeNode(20);
        t.left = new TreeNode(9);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        int a = new Solution().minDepth(t);
        System.out.println(a);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        helper(root,1);
        return min;
    }

    private void helper(TreeNode root,int i){
        if (root.left==null && root.right==null){
            if (i<min)
                min=i;
        }

        if (root.left!=null){
            helper(root.left,i+1);
        }
        if (root.right!=null) {
            helper(root.right, i + 1);
        }

    }
}