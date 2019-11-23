package naum.asafov.com.AddDigits258;

public class Main {
    public static void main(String[] args) {
        int i= 9999;
        int c = Integer.valueOf(String.valueOf(i).substring(0,1));

        System.out.println(c);
        /*5+7+8+2=22
        pervoe-1;*/


    }
}

class Solution {
    public int addDigits(int num) {
        if(num <= 9) return num;
        return num%9 == 0 ? 9:num%9;
    }
}