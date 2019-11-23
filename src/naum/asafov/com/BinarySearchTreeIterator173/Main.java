package naum.asafov.com.BinarySearchTreeIterator173;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.



Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

 */
public class Main {
    public static void main(String[] args) {
        /*List<Integer> l = new LinkedList<>();
        l.add(5);
        l.add(8);
        l.add(2);
        l.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(l.toString());*/

        TreeNode t = new TreeNode(7);
        t.left = new TreeNode(3);
        t.right = new TreeNode(15);
        t.right.right = new TreeNode(20);
        t.right.left = new TreeNode(9);
        BSTIterator b = new BSTIterator(t);
        while (b.hasNext()){
            System.out.println(b.next());
        }
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class BSTIterator {
    private int cursor = 0;
    private List<Integer> list = new LinkedList<>();
    //Sorted Set
    public BSTIterator(TreeNode root) {
        if (root!=null){
            fillList(root,list);
            list.sort(Comparator.comparingInt(Integer::intValue));
        }
//        System.out.println(list.toString());
    }

    /** @return the next smallest number */
    public int next() {
        if (cursor>=list.size()) return -1;
        else return list.get(cursor++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cursor<list.size();
    }

    private void fillList(TreeNode root,List<Integer> list){
        if (root==null) return;

        list.add(root.val);
        fillList(root.left,list);
        fillList(root.right,list);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */