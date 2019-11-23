package naum.asafov.com.mergetwolists;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(11);
        l2.next = new ListNode(22);
        ListNode a = mergeTwoLists(l1,l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode newList = new ListNode(0);
        if (l1 != null || l2 != null){
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    System.out.println("AA");
                    newList = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    newList = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }else if (l1==null){
                newList = new ListNode(l2.val);
                l2 = l2.next;
            }else if (l2==null){
                newList = new ListNode(l1.val);
                l1 = l1.next;
            }
        }
        ListNode temp = newList;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    temp.next = new ListNode(l1.val);
                    temp = temp.next;
                    l1 = l1.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    temp = temp.next;
                    l2 = l2.next;
                }
            }else if (l1==null){
                temp.next = new ListNode(l2.val);
                System.out.println("LL");
                temp = temp.next;
                l2 = l2.next;
            }else if (l2==null){
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                l1 = l1.next;
            }
        }

        System.out.println(newList.val+"zz"+newList.next.next.val+"zz"+newList.next.next.val+"ZZ"+newList.next.next.next.val);
        return newList;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
