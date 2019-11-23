package naum.asafov.com.FindDuplicateSubtrees652;

import java.util.*;

/*
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.

 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.right.left = new TreeNode(2);
        t.right.right = new TreeNode(4);
        t.right.left.left = new TreeNode(4);
        List<TreeNode> list = new Solution().findDuplicateSubtrees(t);
        System.out.println(list.toString());
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    /*@Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}

class Solution {
    private Map<TreeNode,Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root ==null) return null;
        helper(root);
        List<TreeNode> list = new LinkedList<>();
        for (TreeNode node : map.keySet()){
            if (map.get(node) > 1){
                list.add(node);
            }
        }
        return list;
    }
    private void helper(TreeNode root){
        if (root==null) return;
        if (map.containsKey(root)){
            map.put(root,map.get(root)+1);
        }else {
            map.put(root,1);
        }
        helper(root.left);
        helper(root.right);
    }
}




