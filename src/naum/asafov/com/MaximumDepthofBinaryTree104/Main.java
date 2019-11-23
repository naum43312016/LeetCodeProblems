package naum.asafov.com.MaximumDepthofBinaryTree104;

public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        t.right.right.right = new TreeNode(7);

        int m = new Solution().maxDepth(t);
        System.out.println(m);
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {
        helper(root,0);
        return max;
    }

    void helper(TreeNode root,int count){
        if (root==null){
            if (count>max){
                max=count;
            }
        }else {
            helper(root.left,count+1);
            helper(root.right,count+1);
        }
    }
}