package naum.asafov.com.BinaryTreeLevelOrderTraversal102;

import java.util.*;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(2);
        t.right = new TreeNode(4);
        t.left.left = new TreeNode(1);
        t.right.left = new TreeNode(3);
        t.right.right = new TreeNode(-1);
        t.left.left.left = new TreeNode(5);
        t.left.left.right = new TreeNode(1);
        t.right.left.right = new TreeNode(6);
        t.right.right.right = new TreeNode(8);

        List<List<Integer>> l = new Solution2().levelOrder(t);
        System.out.println(l.toString());
    }
}


//sol2
class Solution2{
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return list;
        }

        helper(root,0);

        return list;
    }
    private void helper(TreeNode node,int level){
        if (level==list.size()){
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);

        if(node.left != null)
            helper(node.left,level+1);
        if(node.right != null)
            helper(node.right,level+1);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


//sol1
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(root);
        list.add(Arrays.asList(root.val));
        while (true){

            List<Integer> l = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.poll();
                if (n!=null){
                    l.add(n.val);
                    q2.add(n);
                }
            }
            if (l.size()>0) {
                list.add(l);
            }

            while (!q2.isEmpty()){
                TreeNode node = q2.poll();
                if (node.left!=null && node.right!=null){
                    q.add(node.left);
                    q.add(node.right);
                }else if (node.left!=null && node.right==null){
                    q.add(node.left);
                }else if (node.right!=null && node.left==null){
                    q.add(node.right);
                }
            }
            if (q.isEmpty()){
                break;
            }
        }
        return list;
    }
}