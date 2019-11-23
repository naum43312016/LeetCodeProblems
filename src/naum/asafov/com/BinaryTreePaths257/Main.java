package naum.asafov.com.BinaryTreePaths257;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

 */
public class Main {
    public static void main(String[] args) {
        TreeNode t  =new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.right = new TreeNode(5);
        t.right = new TreeNode(3);
        List<String> l = new Solution().binaryTreePaths(t);
        System.out.println(l.toString());
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {

    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return result;
        }
        helper(root, String.valueOf(root.val));
        return result;
    }

    public void helper(TreeNode root, String current){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            result.add(current);
        }

        if(root.left != null){
            helper(root.left , current + "->"+root.left.val);
        }

        if(root.right != null){
            helper(root.right , current + "->"+root.right.val);
        }

    }
}