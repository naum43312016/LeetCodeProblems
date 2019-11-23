package naum.asafov.com.UniqueBinarySearchTreesII95;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TreeNode t = new TreeNode(1);

        int n = 19;
        List<TreeNode> result = new Solution().generateTrees(n);
        System.out.println(result.size());
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
    List<TreeNode>[][] allTrees;
    public List<TreeNode> generateTrees(int n) {
        allTrees=new List[n+2][n+2];
        return n<=0?new ArrayList():generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> list=new ArrayList();
        if(start>end){list.add(null);return list;}
        for(int i=start;i<=end;i++){
            List<TreeNode> left=null;
            List<TreeNode> right=null;
            if(allTrees[start][i-1]==null){
                left=generateTrees(start,i-1);
            }
            else{
                left=new ArrayList(allTrees[start][i-1]);
            }
            if(allTrees[i+1][end]==null){
                right=generateTrees(i+1,end);
            }
            else{
                right=new ArrayList(allTrees[i+1][end]);
            }
            for(TreeNode a:left){
                for(TreeNode b:right){
                    TreeNode root=new TreeNode(i);
                    root.left=a;
                    root.right=b;
                    list.add(root);
                }
            }
        }
        allTrees[start][end]=list;
        return list;
    }
}