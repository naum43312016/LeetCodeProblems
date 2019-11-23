package naum.asafov.com.SumRoottoLeafNumbers129;
/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        int sum = new Solution().sumNumbers(t);
        System.out.println(sum);
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root==null){
            return 0;
        }


        helper(root,0);
        return sum;
    }

    void helper(TreeNode root,int num){
        num = num*10+root.val;
        if (root.left!=null){
            helper(root.left,num);
        }
        if (root.right!=null){
            helper(root.right,num);
        }

        if (root.right==null&&root.left==null){
            sum+=num;
        }

    }

}