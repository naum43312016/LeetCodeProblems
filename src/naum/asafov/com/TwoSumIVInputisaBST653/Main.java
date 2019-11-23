package naum.asafov.com.TwoSumIVInputisaBST653;

import java.util.HashSet;

/*

    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 */
public class Main {
    public static void main(String[] args) {
        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(3);
        n.left.left = new TreeNode(2);
        n.left.right = new TreeNode(4);
        n.right = new TreeNode(6);
        n.right.right = new TreeNode(7);
        System.out.println(new Solution().findTarget(n,23));
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    private boolean ans = false;
    private HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root==null) return false;
        helper(root,k);
        return ans;
    }

    private void helper(TreeNode node,int k){
        if (ans == true) return;
        if (node==null) return;

        if (set.contains(k-node.val)){
            ans=true;
            return;
        }
        set.add(node.val);
        helper(node.left,k);
        helper(node.right,k);
    }
}