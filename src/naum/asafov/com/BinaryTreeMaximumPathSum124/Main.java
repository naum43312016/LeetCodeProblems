package naum.asafov.com.BinaryTreeMaximumPathSum124;
/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(-10);
        t.left=new TreeNode(9);
        t.right=new TreeNode(20);
        t.right.left=new TreeNode(15);
        t.right.right=new TreeNode(7);
        int max = new Solution().maxPathSum(t);
        System.out.println("Answer is:"+max);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*
[5,4,8,11,null,13,4,7,2,null,null,null,1]
            5
         4       8
      11   n  13   4
    7   2    n  n  n 1


            5
         4       8
      11   n  13   4
    7   2    1
  n  n  n

    48

17+11+
 */
class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxOfNode(root);
        return max;
    }
    int maxOfNode(TreeNode node){
        if(node==null){
            return 0;
        }
        // resultAsRoot if the current node acts as connecting root of left and right subtrees
        int result,resultAsRoot;
        result = resultAsRoot = node.val;
        int left = maxOfNode(node.left);
        int right = maxOfNode(node.right);
        if(left>0)
            resultAsRoot+=left;
        if(right>0)
            resultAsRoot+=right;
        result+= Math.max(0,Math.max(left,right));
        max = Math.max(max,resultAsRoot);
        max = Math.max(max,result);
        return result;
    }
}