package naum.asafov.com.SameTree100;

public class Main {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);


        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        boolean a = new Solution().isSameTree(t1,t2);
        System.out.println(a);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null){
            return true;
        }

        return check(p,q);
    }

    private boolean check(TreeNode p, TreeNode q){
        if (p==null && q==null){
            return true;
        }
        if (p==null && q!=null){
            return false;
        }
        if (q==null && p!=null){
            return false;
        }

        if (p.val!=q.val){
            return false;
        }

        if (!check(p.left,q.left)){
            return false;
        }
        if (!check(p.right,q.right)){
            return false;
        }

        return true;
    }
}