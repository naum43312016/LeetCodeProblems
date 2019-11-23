package naum.asafov.com.RemoveDuplicatesfromSortedList82;
/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:
Input: 1->1->1->2->3
Output: 2->3
 */
public class Main {
    public static void main(String[] args) {
        ListNode l = new ListNode(0);
        l.next = new ListNode(1);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(2);
        l.next.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next.next.next.next.next.next.next = new ListNode(6);
        l.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(6);
        l.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(7);

        ListNode listNode = new Solution().deleteDuplicates(l);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }


        ListNode temp = head;
        boolean flag=false;
        //if (temp!=null && temp.next!=null)
        while (true) {
            if (temp.next==null){
                break;
            }
            while (temp.next!=null && temp.val == temp.next.val) {
                temp = temp.next;
                flag = true;
            }
            if (!flag){
                break;
            }

            temp=temp.next;
            if (temp==null){
                break;
            }
            if (temp.next==null){
                break;
            }
            if (temp.val != temp.next.val){
                break;
            }
        }
        if (flag) {
            head = temp;
        }
        temp = head;

        while (temp!=null){
            flag=false;
            ListNode node = temp.next;
            while (node!=null && node.next!=null && node.val==node.next.val){
                node=node.next;
                flag=true;
            }
            if (flag){
                temp.next=node.next;
                //temp=temp.next;
            }else {
                temp=temp.next;
            }
        }

        /*while (temp.next!=null){

        }*/

        return head;
    }
}
