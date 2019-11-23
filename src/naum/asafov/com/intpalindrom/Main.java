package naum.asafov.com.intpalindrom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int x = 1551;
        boolean answer = isPalindrome(x);
        System.out.println(answer);
    }

    private static boolean isPalindrome(int x){
        if (x==0){
            return true;
        }
        if (x<0){
            return false;
        }

        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(x, digits);
        Collections.reverse(digits);
        //System.out.println(x);
        //System.out.println(digits);
        int[] array = digits.stream().mapToInt(i->i).toArray();
        int reverse = arrayToInt(array);
        if (reverse == x){
            return true;
        }else {
            return false;
        }
    }

    private static int arrayToInt(int[] arr)
    {
        int result = 0;

        //iterate backwards through the array so we start with least significant digits
        for (int n = arr.length - 1, i = 1; n >= 0; n --, i *= 10)
        {
            result += Math.abs(arr[n]) * i;
        }

        if (arr[0] < 0) //if there's a negative sign in the beginning, flip the sign
        {
            result = - result;
        }

        return result;
    }
    private static void collectDigits(int num, List<Integer> digits) {
        if(num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }
}
