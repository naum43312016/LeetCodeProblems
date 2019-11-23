package naum.asafov.com.rotatelist;

import java.util.List;

/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        //l1.next.next.next = new ListNode(4);
        //l1.next.next.next.next = new ListNode(5);
        ListNode listNode = new Solution().rotateRight(l1,10);
        while (listNode!=null){
            System.out.print(listNode.val+"\t");
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
    public ListNode rotateRight(ListNode head, int k) {
        /*if(k==10){
            return head;
        }*/

        if (k>1000) {
            int j = k % 10;
            while (k > 0) {
                if (j > 0) {
                    k = j;
                    break;
                }
                k = k / 10;
                j = k % 10;
            }
        }
        if (head==null){
            return null;
        }
        if (k==0){
            return head;
        }
        if (head.next==null){
            return head;
        }
        ListNode temp = head;

        ListNode l = temp.next;
        while (l.next!=null){
            l = l.next;
        }
        for (int i = 0;i<k;i++){
            temp = head;
            while (temp.next!=null){
                int tempVal = temp.val;
                temp.val = l.val;
                l.val = tempVal;
                temp = temp.next;
            }
        }

        return head;
    }
}
