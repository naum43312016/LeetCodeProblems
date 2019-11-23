package naum.asafov.com.PopulatingNextRigtPointersinEachNodeII117;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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