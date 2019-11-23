package naum.asafov.com.InsertionSortList147;
/*
Sort a linked list using insertion sort.

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */
public class Main {
    public static void main(String[] args) {
        ListNode l = new ListNode(4);
        l.next = new ListNode(2);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(3);
        ListNode sorted = new Solution().insertionSortList(l);
        System.out.println(sorted);

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
    public ListNode insertionSortList(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }

        ListNode sorted = new ListNode(head.val);

        ListNode h = head.next;

//Input: 4->2->1->3
        while (h!=null){
            //ListNode temp = sorted;
            if (h.val<=sorted.val){
                ListNode l = new ListNode(h.val);
                l.next = sorted;
                sorted = l;
            }else {
                ListNode temp = sorted;
                while (temp!=null){
                    if (temp.next==null){
                        ListNode l = new ListNode(h.val);
                        temp.next = l;
                        break;
                    }else {
                        if (h.val<=temp.next.val){
                            ListNode l = new ListNode(h.val);
                            l.next = temp.next;
                            temp.next = l;
                            break;
                        }else {
                            temp=temp.next;
                        }
                    }
                }
            }

            h=h.next;
        }



        return sorted;
    }
}