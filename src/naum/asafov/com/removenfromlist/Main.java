package naum.asafov.com.removenfromlist;


/*
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode node = removeNthFromEnd(list,1);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int i =0;
        while (temp!=null){
            i++;
            temp=temp.next;
        }
        if (i==1){
            return null;
        }
        if (i==2 && n==2){
            head=head.next;
            return head;
        }
        //System.out.println(i);
        int rem = i-n;
        temp = head;
        int j = 0;
        while (temp!=null){
            if (rem==j+1){
                //System.out.println("Value="+temp.val);
                if (temp.next.next!=null){
                    temp.next = temp.next.next;
                    //System.out.println("yd="+true);
                    break;
                }else {
                    temp.next=null;
                }
            }
            temp=temp.next;
            j++;
        }
        return head;
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

