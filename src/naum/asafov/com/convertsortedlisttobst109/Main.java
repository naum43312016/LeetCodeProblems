package naum.asafov.com.convertsortedlisttobst109;


public class Main {
    public static void main(String[] args) {
        ListNode l = new ListNode(-10);
        l.next = new ListNode(-3);
        l.next.next = new ListNode(0);
        l.next.next.next = new ListNode(5);
        l.next.next.next.next = new ListNode(9);
        TreeNode root = new Solution().sortedListToBST(l);
        System.out.println(root);
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null){
            return null;
        }
        int len=0;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            len++;
        }
        int[] nums = new int[len];
        int i =0;
        temp = head;
        while (temp!=null){
            nums[i] = temp.val;
            temp = temp.next;
            i++;
        }
        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null || nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        TreeNode root = null;
        if(start > end)
            return null;
        else{
            int mid = (start + end) / 2;
            root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid - 1);
            root.right = sortedArrayToBST(nums, mid+1, end);
        }

        return root;
    }
}