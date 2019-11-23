package naum.asafov.com.SymmetricTree101;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(2);
        t.right.right = new TreeNode(3);
        t.right.left = new TreeNode(4);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(4);

//        TreeNode t = new TreeNode(1);
//        t.left = new TreeNode(2);
//        t.right = new TreeNode(2);
//        t.right.right = new TreeNode(3);
//        t.left.right = new TreeNode(3);
        boolean b = new Solution().isSymmetric(t);
        System.out.println(b);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root==null){
            return true;
        }
        if (root.right==null && root.left==null){
            return true;
        }

        return isSym(root.left,root.right);
    }

    private boolean isSym(TreeNode t1,TreeNode t2){
        if (t1==null && t2==null){
            return true;
        }

        if (t1==null || t2==null){
            return false;
        }



        if (t1.val!=t2.val){
            return false;
        }else {
            if (!isSym(t1.left,t2.right)){
                return false;
            }

            if (!isSym(t1.right,t2.left)){
                return false;
            }
            return true;
        }
    }
}
