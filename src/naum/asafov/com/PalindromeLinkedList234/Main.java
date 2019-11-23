package naum.asafov.com.PalindromeLinkedList234;

public class Main {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(0);
        l.next.next = new ListNode(0);
        l.next.next.next = new ListNode(3);
        System.out.println(new Solution().isPalindrome(l));
    }
}
/*
Example 2:

Input: 1->2->2->1
Output: true

 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

class Solution {
    boolean ans = true;
    public boolean isPalindrome(ListNode head) {
        if (head==null){
            return true;
        }

        helper(head,head);
        return ans;
    }
    private ListNode helper(ListNode node,ListNode head){
        if (node==null){
            return head;
        }
        ListNode h = helper(node.next,head);
        if (h==null){
            return null;
        }
        if (h.val!=node.val){
            ans= false;
        }


        if (h==node){
            return null;
        }
        return h.next;
    }
}