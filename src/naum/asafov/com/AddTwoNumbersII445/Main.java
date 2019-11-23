package naum.asafov.com.AddTwoNumbersII445;

import java.math.BigInteger;
import java.util.Arrays;

/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l = new Solution().addTwoNumbers(l1,l2);
        System.out.println(l);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder str1=new StringBuilder();
        StringBuilder str2=new StringBuilder();
        buildNum(l1,str1);
        buildNum(l2,str2);
        BigInteger x = new BigInteger(str1.toString());
        BigInteger y = new BigInteger(str2.toString());
        BigInteger res = x.add(y);
        //System.out.println(res);
        String temp = res.toString();
        int[] resArr = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            resArr[i] = temp.charAt(i) - '0';
        }
        ListNode list = new ListNode(resArr[0]);
        buildList(resArr,1,list);
        return list;
    }

    private void buildList(int[] res,int i,ListNode list){
        if (i==res.length){
            return;
        }
        list.next = new ListNode(res[i]);
        buildList(res,i+1,list.next);
    }

    private void buildNum(ListNode l, StringBuilder str) {
        if (l==null){
            return;
        }
        str.append(l.val);
        buildNum(l.next,str);
    }
}