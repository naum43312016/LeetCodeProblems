package naum.asafov.com.BinaryTreeLevelOrderTraversalII107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

 */

public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        /*t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);*/
        List<List<Integer>> l = new Solution().levelOrderBottom(t);
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
    List<List<Integer>> list = new ArrayList<>();
    int maxLev = 0;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null){
            return list;
        }
        findMax(root,0);
        if (maxLev==0){
            list.add(Arrays.asList(root.val));
            return list;
        }
        for (int i=0;i<=maxLev;i++){
            list.add(new ArrayList<>());
        }

        helper(root,maxLev);
        return list;
    }

    void findMax(TreeNode node,int level){
        if (level>maxLev){
            maxLev = level;
        }
        if(node.left != null)
            findMax(node.left,level+1);
        if(node.right != null)
            findMax(node.right,level+1);
    }

    void helper(TreeNode root,int lev){
        list.get(lev).add(root.val);

        if(root.left != null)
            helper(root.left,lev-1);
        if(root.right != null)
            helper(root.right,lev-1);
    }
}