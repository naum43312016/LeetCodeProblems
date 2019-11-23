package naum.asafov.com.swapnodes;

public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(5);
        ListNode ans = new Solution().swapPairs(list);
        System.out.println(ans.val+":"+ans.next.val+":"+ans.next.next.val+":"+ans.next.next.next.val);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode list = head;
        while (list!=null){
            if (list.next!=null){
                int val = list.val;
                list.val = list.next.val;
                list.next.val = val;
                list = list.next.next;
            }else {
                list = list.next;
            }
        }
        return head;
    }
}