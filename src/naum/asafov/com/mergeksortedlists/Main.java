package naum.asafov.com.mergeksortedlists;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(4);
        list.next.next = new ListNode(5);
        //list.next.next.next = new ListNode(6);

        /*ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        ListNode ans = new Solution().mergeKLists(new ListNode[]{list,list2,list3});
        //System.out.println(list.val + ":" + list.next.val + ":" + list.next.next.val);
        System.out.println(ans.val + ":" + ans.next.val + ":" + ans.next.next.val + ":" + ans.next.next.next.val
        +":"+ans.next.next.next.next.val+":"+ans.next.next.next.next.next.val+":"+ans.next.next.next.next.next.next.val
        +":"+ans.next.next.next.next.next.next.next.val);*/

        /*ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        //ListNode l2 = null;
        ListNode ans = new Solution().mergeKLists(new ListNode[]{l1,l2});

        System.out.println(ans.val+":"+ans.next.val);*/

        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(11);
        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(10);
        //ListNode l2 = null;
        ListNode ans = new Solution().mergeKLists(new ListNode[]{l1,l2});

        System.out.println(ans.val+":"+ans.next.val+":"+ans.next.next.val+":"+ans.next.next.next.val+":"+ans.next.next.next.next.val);
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }

        int y = 0;
        for (;y<lists.length;y++){
            if (lists[y] !=null){
                break;
            }
        }
        if(y==lists.length){
            return null;
        }
        ListNode list = lists[y];
        ListNode temp = list;
        for (int i = y+1;i<lists.length;i++){
            temp = list;
            ListNode temp2 = lists[i];
            while (temp!=null){
                if (temp2==null){
                    break;
                }

                while (temp2!=null){
                    if (temp2.val<=temp.val){
                        int val = temp2.val;//0
                        temp2.val = temp.val;//1
                        temp.val = val;//0
                        ListNode l = new ListNode(temp2.val);//1
                        l.next = temp.next;//null
                        temp.next=l;
                        System.out.println("P");
                        temp2=temp2.next;
                    }else {
                        if (temp.next==null){
                            System.out.println("T");

                            temp.next=temp2;
                            temp2=null;
                            break;
                        }
                        temp = temp.next;
                    }
                }
            }
        }

        return list;
    }
}