package naum.asafov.com.KthSmallestElementinaBST230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
//idem vlevo do konca potom kth nazad
 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(3);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(4);
        t.left.left.left = new TreeNode(1);
        t.right = new TreeNode(6);
        int k = 3;
        int ans = new Solution().kthSmallest(t,k);
        System.out.println("Answer="+ans);
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {
    List<Integer> list =new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        bstMin(root);
        Collections.sort(list);
        System.out.println(list.toString());
        return list.get(k-1);
    }

    private void bstMin(TreeNode node){
        if (node==null){
            return;
        }

        bstMin(node.left);

        bstMin(node.right);
        list.add(node.val);
    }
}