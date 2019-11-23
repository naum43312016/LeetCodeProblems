package naum.asafov.com.bintreezigzag103;

import java.util.*;

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

        List<List<Integer>> l = new Solution().zigzagLevelOrder(t);
        System.out.println(l.toString());

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<List<Integer>> zigzag=new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return zigzag;
        helper(root,0);
        return zigzag;
    }

    public void helper(TreeNode root,int level)
    {
        if(level==zigzag.size())
            zigzag.add(new ArrayList<Integer>());

        if(level % 2 ==0)
        {
            zigzag.get(level).add(root.val);
        }
        else
        {
            zigzag.get(level).add(0,root.val);
        }

        if(root.left != null)
            helper(root.left,level+1);
        if(root.right != null)
            helper(root.right,level+1);

    }
}