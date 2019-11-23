package naum.asafov.com.PartitionList86;
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */

/*
1->3,2,5,2,4
1,2,5,2,4,3
1,2,2,4,3,5
 */
public class Main {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(2);


        int x = 3;
        ListNode node = new Solution().partition(l,x);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }

        int count = 0;
        ListNode temp = head;
        while (temp!=null){
            if (temp.val>=x){
                count++;
            }
            temp=temp.next;
        }

        temp = head;
        while (temp!=null){
            if (count==0){
                break;
            }
            if (temp.val>=x){
                shift(temp);
                count--;
            }else {
                temp=temp.next;
            }
        }

        //System.out.println("C="+count);
        return head;
    }
    private void shift(ListNode temp){
        ListNode l = temp;
        while (l.next!=null){
            int t = l.val;
            l.val = l.next.val;
            l.next.val = t;
            l = l.next;
        }
    }
}