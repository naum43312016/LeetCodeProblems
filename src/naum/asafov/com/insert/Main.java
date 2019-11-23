package naum.asafov.com.insert;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3};
        int t = 5;
        int a = new Solution().searchInsert(arr,t);
        System.out.println(a);
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {

        return runBinarySearchIteratively(nums,target,0,nums.length-1);
    }

    public int runBinarySearchIteratively(
            int[] sortedArray, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
            if (low==0){
                index = mid;
            }else if (low==sortedArray.length){
                index = mid+1 ;
            }else {
                index = low;
            }
        }

        return index;
    }
}
