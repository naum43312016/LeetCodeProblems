package naum.asafov.com.PathSum112;
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(4);
        t.right = new TreeNode(8);
        t.right.left = new TreeNode(13);
        t.right.right = new TreeNode(4);
        t.right.right.right = new TreeNode(1);
        t.left.left = new TreeNode(11);
        t.left.left.left = new TreeNode(7);
        t.left.left.right = new TreeNode(2);

        int sum = 22;
        boolean a = new Solution().hasPathSum(t,sum);
        System.out.println("Answer:"+a);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }


        return helper(root,sum,0);
    }

    boolean helper(TreeNode root,int sum,int i){
        boolean a = false;
        if (root.left==null && root.right==null){
            i+=root.val;
            if (i==sum){
                a= true;
                return a;
            }else {
                a= false;
                return a;
            }
        }

        if (root.left!=null && helper(root.left,sum,i+root.val)){
            a= true;
            return a;
        }
        if (root.right!=null&&helper(root.right,sum,i+root.val)){
            a= true;
            return a;
        }

        return a;
    }
}