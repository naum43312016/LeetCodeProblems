package naum.asafov.com.PopulatingNextRightPointersinEachNode116;

import java.util.ArrayList;
import java.util.List;

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node left;
  Node right;
  Node next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
 */
public class Main {
    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        new Solution().connect(root);
        System.out.println(root.left);
    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int _val) {
        val= _val;
    }
    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
class NodeLevel{
    Node node;
    int level;
    int i;

    public NodeLevel(Node node, int level, int i) {
        this.node = node;
        this.level = level;
        this.i = i;
    }

    @Override
    public String toString() {
        return "NodeLevel{" +
                "node=" + node +
                ", level=" + level +
                ", i=" + i +
                '}';
    }
}
/*
list = level polojenie i node
 */
class Solution {
    List<List<NodeLevel>> list = new ArrayList<>();

    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        if (root.left==null && root.right==null){
            return root;
        }
        initList(root,0,0);

        for (int i =0;i<list.size();i++){
            for (int j = 0;j<list.get(i).size()-1;j++){
                NodeLevel temp = list.get(i).get(j);
                temp.node.next = list.get(i).get(j+1).node;
            }
        }
        return root;
    }

    private void initList(Node root,int lev,int i){
        if (root==null){
            return;
        }
        if (lev==list.size()){
            list.add(new ArrayList<>());
        }
        list.get(lev).add(new NodeLevel(root,lev,i));
        initList(root.left,lev+1,i+1);
        initList(root.right,lev+1,i+1);

    }
}