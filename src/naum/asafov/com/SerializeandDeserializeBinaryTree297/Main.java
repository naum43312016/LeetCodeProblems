package naum.asafov.com.SerializeandDeserializeBinaryTree297;

import java.util.ArrayList;
import java.util.List;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

 */
public class Main {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(12);
        t.right = new TreeNode(3);
        t.right.left = new TreeNode(4);
        t.right.right = new TreeNode(5);
        Codec c = new Codec();
        String ser = c.serialize(t);
        System.out.println(t);
        TreeNode tree = c.deserialize(ser);
        System.out.println(tree);

        /*StringBuilder bu = new StringBuilder();
        bu.append(5);
        bu.append("n");
        bu.append(6);
        String str = bu.toString();

        System.out.println(str.charAt(0));
        System.out.println(str.charAt(1));
        System.out.println(str.charAt(2));*/

    }
}
/*
//    private TreeNode deSerRec(String[] data){
//        if (data[j].equals("n")){
//            return null;
//        }
//        TreeNode node = new TreeNode(Integer.valueOf(data[j]));
//        j++;
//        node.left = deSerRec(data);
//        j++;
//        node.right = deSerRec(data);
//        return node;
//    }
 */