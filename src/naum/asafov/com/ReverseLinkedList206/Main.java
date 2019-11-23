package naum.asafov.com.ReverseLinkedList206;

import java.util.ArrayList;
import java.util.List;

/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

 */
public class Main {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode ans = new Solution().reverseList(l);
        System.out.println(ans);
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


class Solution {
    public ListNode reverseList(ListNode head) {

        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }


        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        int i=0,j=list.size()-1;
        while (i<j){
            int t = list.get(i).val;
            list.get(i).val=list.get(j).val;
            list.get(j).val = t;
            i++;
            j--;
        }


        return head;

    }
}