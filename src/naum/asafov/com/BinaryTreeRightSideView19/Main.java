package naum.asafov.com.BinaryTreeRightSideView19;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.right = new TreeNode(5);
        t.right = new TreeNode(3);
        t.right.right = new TreeNode(4);
        List<Integer> list = new Solution().rightSideView(t);
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
    private List<List<Integer>> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }

        helper(root,0);
        List<Integer> res = new ArrayList<>();
        for (List<Integer> l : list){
            res.add(l.get(l.size()-1));
        }


        return res;
    }
    private void helper(TreeNode root,int i){
        if (root==null) return;
        if (i==list.size()){
            list.add(new ArrayList<>());
        }

        helper(root.left,i+1);
        helper(root.right,i+1);
        list.get(i).add(root.val);


    }
}