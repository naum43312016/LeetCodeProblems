package naum.asafov.com.LargestRectangleinHistogram84;
/*
Hard:Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {2,1,2};
        int a = new Solution().largestRectangleArea(arr);
        System.out.println("Answers is:" + a);
    }
}


class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        if (heights==null){
            return 0;
        }
        if (heights.length==0)
            return 0;
        if (heights.length==1){
            return heights[0];
        }

        if (heights[heights.length-1]>max){
            max = heights[heights.length-1];
        }
        for (int i = 0;i<heights.length-1;i++){
            if (heights[i]>max){
                max = heights[i];
            }
            int sum = 0;
            int k = i;
            for (int j = i+1;j<heights.length;j++){
                if (heights[j]==0){
                    break;
                }
                if (heights[k] <= heights[j]){
                    if (sum==0) {
                        sum = heights[k] + heights[k] + sum;
                    }else {
                        sum +=heights[k];
                    }
                    if (sum>max){
                        max = sum;
                    }
                }else if (heights[k] > heights[j]){
                    if (sum==0) {
                        sum = heights[j] + heights[j] + sum;
                    }else {
                        sum = 0;
                        for (int y=i;y<=j;y++){
                            sum+=heights[j];
                        }
                    }
                    k=j;
                    if (sum>max){
                        max = sum;
                    }
                }
            }
        }


        return max;
    }
}