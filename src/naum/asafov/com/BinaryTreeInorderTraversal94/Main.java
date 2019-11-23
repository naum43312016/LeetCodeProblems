package naum.asafov.com.BinaryTreeInorderTraversal94;

import java.util.ArrayList;
import java.util.List;
/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:
Inorder (Left, Root, Right) :
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);;
        root.left.left = new TreeNode(4);;
        root.left.right = new TreeNode(5);;
        root.right = new TreeNode(3);
        List<Integer> result = new Solution().inorderTraversal(root);
        System.out.println(result.toString());
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



//Recursive solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        traverse(result,root);
        return result;
    }
    private void traverse(List<Integer> res,TreeNode node){
        if (node.left!=null){
            traverse(res,node.left);
            res.add(node.val);
            if (node.right!=null){
                traverse(res,node.right);
            }
        }else {
            res.add(node.val);
            if (node.right!=null){
                traverse(res,node.right);
            }
        }
    }
}