package naum.asafov.com.PowerofTwo231;

public class Main {
    public static void main(String[] args) {
        int i = 16;

        System.out.println(new Solution().isPowerOfTwo(i));
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<1){
            return false;
        }
        if (n==1 || n==2){
            return true;
        }
        if (n>2147483645){
            return false;
        }
        if ((n%10)%2!=0){
            return false;
        }
        int j = 2;
        while (j <n){
            j=j*2;
        }
        return j==n;
    }
}