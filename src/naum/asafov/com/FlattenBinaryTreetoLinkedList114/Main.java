package naum.asafov.com.FlattenBinaryTreetoLinkedList114;
/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        //t.left.left = new TreeNode(3);
        //t.left.right = new TreeNode(4);
        t.right = new TreeNode(5);
        //t.right.right = new TreeNode(6);
        new Solution().flatten(t);
        System.out.println(t);
    }
}
/*
            1
           2  5
               6
          3
 */
/*
       1
        2
         3
          4
            5
             6
 */
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
    public void flatten(TreeNode root) {
        if (root!=null) {
            helper(root.left);
            helper(root.right);
            helper(root);
        }
    }

    private void helper(TreeNode root){
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null){
            return;
        }

        if (root.right==null){
            root.right = root.left;
            root.left=null;
            helper(root.right);
        }

        if (root.left==null){
            helper(root.right);
        }else {
            replace(root,root.right);
            helper(root.right);
        }
    }
    void replace(TreeNode root,TreeNode right){
        if (root==null || right==null){
            return;
        }
        TreeNode temp = right;
        TreeNode tempL=root.left;

        while (tempL.right!=null){
            tempL = tempL.right;
        }


        tempL.right = temp;
        root.right = root.left;
        root.left = null;


    }
}