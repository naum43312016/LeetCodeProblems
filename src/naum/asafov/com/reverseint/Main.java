package naum.asafov.com.reverseint;

public class Main {
    public static void main(String[] args) {
        int x = -321;
        int a = new Main().reverse(x);
        System.out.println(a);


    }
    public int reverse(int x) {
        if (x==0){
            return x;
        }
        boolean minus = false;
        if (x<0){
            minus=true;
        }
        if (!minus){
            StringBuilder s = new StringBuilder(String.valueOf(x));
            String str = new String(s.reverse());
            try {
                x = Integer.valueOf(str);
            }catch (NumberFormatException e){
                x = 0;
            }
            return x;
        }else {
            x = x-x-x;
            StringBuilder s = new StringBuilder(String.valueOf(x));
            String str = new String(s.reverse());
            x = Integer.valueOf(str);
            x=x-x-x;
            return x;
        }
    }
}
