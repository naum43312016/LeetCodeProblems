package naum.asafov.com.PathSumII113;

import java.util.ArrayList;
import java.util.List;
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.
Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(4);
        t.right = new TreeNode(8);
        t.right.left = new TreeNode(13);
        t.right.right = new TreeNode(4);
        t.right.right.right = new TreeNode(1);
        t.right.right.left = new TreeNode(5);
        t.left.left = new TreeNode(11);
        t.left.left.left = new TreeNode(7);
        t.left.left.right = new TreeNode(2);


        List<List<Integer>> a = new Solution().pathSum(t,22);
        System.out.println("Answer:"+a.toString());
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null){
            return lists;
        }
        helper(root,sum,0,new ArrayList<>());
        return lists;
    }
    void helper(TreeNode root,int sum,int i,List<Integer> list){
        if (root.left==null && root.right==null){
            i+=root.val;
            if (i==sum){
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }else {
                return;
            }
        }

        if (root.left!=null) {
            list.add(root.val);
            helper(root.left, sum, i + root.val, list);
            list.remove(list.size()-1);
        }

        if (root.right!=null){
            list.add(root.val);
            helper(root.right,sum,i+root.val,list);
            list.remove(list.size()-1);
        }

    }
}