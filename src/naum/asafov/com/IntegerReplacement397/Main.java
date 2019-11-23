package naum.asafov.com.IntegerReplacement397;

public class Main {
    public static void main(String[] args) {
        int min = new Solution().integerReplacement(7);
        System.out.println(min);
    }
}
class Solution {
    int min= Integer.MAX_VALUE;
    public int integerReplacement(int n) {
        if (n==1){
            return 0;
        }
        helper(n,0);
        return min;
    }
    private void helper(int n,int count){
        if (n==1){
            min = Math.min(min,count);
            return;
        }

        if (n%2==0){
            helper(n/2,count+1);
        }else {
            helper(n+1,count+1);
            helper(n-1,count+1);
        }
    }
}