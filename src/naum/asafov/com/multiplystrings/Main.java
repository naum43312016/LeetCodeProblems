package naum.asafov.com.multiplystrings;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String number1 = "25";
        String number2 = "2";
        String a = multiply(number1,number2);
        System.out.println(a);

    }
    public static String multiply(String num1, String num2) {
        if((num1.length()==1 && num1.equals("0")) || (num2.length()==1 && num2.equals("0"))) return "0";
        int[] ret = new int[num1.length()+num2.length()];//3
        Arrays.fill(ret,0);
        char[] arr1 = num1.toCharArray();//25
        char[] arr2 = num2.toCharArray();//22
        int flag = 0;
        for(int i = num2.length()-1;i>=0;i--){
            int index = ret.length-1 - flag;//2
            for(int j = num1.length()-1;j>=0;j--){
                ret[index--] += (arr2[i] - '0') * (arr1[j] - '0');
            }
            flag++;
        }
        //ret[0][5][0]
        for(int i = ret.length-1;i >= 0;i--){//0
            if(i-1 >= 0){
                ret[i-1] += ret[i] / 10;
            }
            ret[i] %= 10;
        }
        int i = 0;
        if(ret[0] == 0) i++;
        StringBuilder sb = new StringBuilder();
        for(;i < ret.length;i++){
            sb.append(ret[i]);
        }
        return sb.toString();
    }
}