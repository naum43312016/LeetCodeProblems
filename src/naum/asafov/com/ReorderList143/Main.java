package naum.asafov.com.ReorderList143;
/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 */
public class Main {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        //l.next.next.next.next = new ListNode(5);
        System.out.println("BEFORE");
        System.out.println(l);
        System.out.println("AFTER");
        new Solution().reorderList(l);
        System.out.println(l);
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

     @Override
     public String toString() {
         return "ListNode{" +
                 "val=" + val +
                 ", next=" + next +
                 '}';
     }
 }
 //1,2,3,4
//
class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null){
            return;
        }

        ListNode temp = head;
        while (temp!=null){
            ListNode t = temp;
            if (temp.next==null){
                break;
            }
            while (t.next.next!=null){

                t=t.next;
            }
            if (t==temp){
                break;
            }

            t.next.next = temp.next;
            temp.next = t.next;
            t.next = null;
            temp = temp.next.next;
        }

    }
}
