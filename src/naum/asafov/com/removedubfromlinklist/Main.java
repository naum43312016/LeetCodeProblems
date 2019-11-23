package naum.asafov.com.removedubfromlinklist;
/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
Example 1:
Input: 1->1->2
Output: 1->2
Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
 */
public class Main {
    public static void main(String[] args) {

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
        while (temp!=null){
            if (temp.next!=null){
                if (temp.val == temp.next.val){
                    if (temp.next.next==null){
                        temp.next=null;
                        temp=temp.next;
                    }else {
                        temp.next = temp.next.next;
                    }
                }else {
                    temp = temp.next;
                }
            }else {
                temp = temp.next;
            }
        }
        return head;
    }
}
