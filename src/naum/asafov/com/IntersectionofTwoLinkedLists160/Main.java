package naum.asafov.com.IntersectionofTwoLinkedLists160;

import java.util.List;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.



 */
public class Main {
    public static void main(String[] args) {
        ListNode l = new ListNode(4);
        ListNode l2 = new ListNode(4);
        System.out.println(l==l2);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }
        ListNode tA=headA.next;
        while (tA!=null){
            ListNode tB = headB.next;
            while (tB!=null){
                if (tA==tB){
                    return tB;
                }
                tB=tB.next;
            }
            tA=tA.next;
        }

        return null;
    }
}