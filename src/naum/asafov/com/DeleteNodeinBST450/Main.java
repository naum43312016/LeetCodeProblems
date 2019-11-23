package naum.asafov.com.DeleteNodeinBST450;

public class Main {
    public static void main(String[] args) {
        //5,3,6,2,4,null,7
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(3);
        t.right = new TreeNode(6);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(7);
        TreeNode node = new Solution().deleteNode(t,5);
        System.out.println(node);
    }
}


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

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr=root;
        TreeNode parent=null;
        while(curr!=null&&curr.val!=key){
            parent = curr;
            if(key<curr.val)
                curr=curr.left;
            else
                curr=curr.right;
        }
        if(curr==null)
            return root;
        //case1: curr have no children
        if(curr.left==null&&curr.right==null){
            if(parent==null)
                root=null;
            else if(parent.left==curr)
                parent.left=null;
            else
                parent.right=null;
        }
        //case2:curr have one children, promote it
        else if(curr.left==null||curr.right==null){
            if(curr.left==null){
                if(parent==null)
                    root=curr.right;
                else if(parent.left==curr)
                    parent.left=curr.right;
                else
                    parent.right=curr.right;
            }else{
                if(parent==null)
                    root=curr.left;
                else if(parent.left==curr)
                    parent.left=curr.left;
                else
                    parent.right=curr.left;
            }
        }
        //case3:curr have two children, find successor and replace curr with it
        else{
            TreeNode succ = findSuccessor(curr);
            deleteNode(root , succ.val);
            curr.val=succ.val;
        }
        return root;
    }

    //curr's successor is the smallest of curr's right tree
    public TreeNode findSuccessor(TreeNode root){
        root=root.right;
        while(root.left!=null)
            root=root.left;
        return root;
    }
}