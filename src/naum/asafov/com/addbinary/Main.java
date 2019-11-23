package naum.asafov.com.addbinary;

public class Main {
    public static void main(String[] args) {
        String s1 = "1010";
        String s2 = "1011";
        String a = new Solution().addBinary(s1,s2);
        System.out.println(a);
    }
}
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        if (a.length()> b.length()){
            b =addZero(b,a.length()-b.length());
        }else if(a.length()< b.length()){
            a = addZero(a,b.length()-a.length());
        }
        System.out.println("a = " + a + "b= " + b);
        boolean flag = false;
        for (int i = a.length()-1;i>=0;i--){
           flag = add(str,a.charAt(i),b.charAt(i),flag);
        }
        if (flag) {
            str.insert(0, "1");
        }
        return str.toString();
    }
    private boolean add(StringBuilder str,char a,char b,boolean flag){
        if (a == '1' && b == '1'){
            if (flag){
                str.insert(0,"1");
                return true;
            }else {
                str.insert(0,"0");
                return true;
            }
        }else if (a == '1' || b == '1'){
            if (flag){
                str.insert(0,"0");
                return true;
            }else {
                str.insert(0,"1");
                return false;
            }
        }else {
            if (flag){
                str.insert(0,"1");
                return false;
            }else {
                str.insert(0,"0");
                return false;
            }
        }
    }

    //11+1
    //

    private String addZero(String s,int len){
        String temp = "";
        for (int i =0;i<len;i++){
            temp = temp.concat("0");
        }
        s = temp.concat(s);
        return s;
    }
}

