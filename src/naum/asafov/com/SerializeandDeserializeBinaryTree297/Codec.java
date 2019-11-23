package naum.asafov.com.SerializeandDeserializeBinaryTree297;

import java.util.Arrays;
import java.util.List;

/*
You may serialize the following tree:
    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
 */
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

class Node{
    TreeNode node;
    int index;
}
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "";
        }
        StringBuilder str = new StringBuilder();
        serializeRec(str,root);
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.length()==0){
            return null;
        }
        Node n = deSerRec(data.split(","),0);;
        return n.node;
    }

    private Node deSerRec(String[] data,int i){
        if (data[i].equals("n")){
            Node temp = new Node();
            temp.node=null;
            temp.index=i;
            return temp;
        }
        TreeNode node = new TreeNode(Integer.valueOf(data[i]));
        Node root = new Node();
        root.node = node;
        root.index = i;
        Node n = deSerRec(data,root.index+1);
        root.node.left = n.node;
        root.index = n.index;
        n = deSerRec(data,n.index+1);
        root.node.right = n.node;
        root.index=n.index;
        return root;
    }

    private void serializeRec(StringBuilder str,TreeNode node){
        if (node==null){
            str.append("n,");
            return;
        }

        str.append(node.val+",");
        serializeRec(str,node.left);
        serializeRec(str,node.right);
    }
}