package naum.asafov.com.atoi;

public class Main {

    public static final int ASCII_SPACE = 32;
    public static final int ASCII_PLUS = 43;
    public static final int ASCII_MINUS = 45;
    public static final int ASCII_MIN = 48;
    public static final int ASCII_MAX = 57;
    public static void main(String[] args) {
        String s = " --2";
        //int i = (int) s.charAt(0);
        //System.out.println(i);
        //char c = (char) i;
        //System.out.println(c);
        int answer = atoi(s);
        System.out.println(answer);
    }

    private static int atoi(String str){
        StringBuilder stringBuilder = new StringBuilder();
        boolean minus = false;
        boolean plus = false;
        int number;
        try{
            for (int i =0;i<str.length();i++){
                number = (int)str.charAt(i);
                if (number!=ASCII_PLUS && number  != ASCII_SPACE && number!=ASCII_MINUS && number <ASCII_MIN || number >ASCII_MAX){
                    if (!stringBuilder.toString().equals("")) {
                        return Integer.valueOf(stringBuilder.toString());
                    } else {
                        return 0;
                    }
                }else {
                    if (number==ASCII_SPACE){
                        if (!stringBuilder.toString().equals("")) {
                            return Integer.valueOf(stringBuilder.toString());
                        } else {
                            return 0;
                        }
                    } else if (number  == ASCII_MINUS){
                        if (!minus && !plus){
                            minus = true;
                            stringBuilder.append((char)number);
                        }else {
                            if (!stringBuilder.toString().equals("")) {
                                return Integer.valueOf(stringBuilder.toString());
                            } else {
                                return 0;
                            }
                        }
                    }else if (number  == ASCII_PLUS){
                        if (!minus && !plus){
                            plus=true;
                        }else {
                            if (!stringBuilder.toString().equals("")) {
                                return Integer.valueOf(stringBuilder.toString());
                            } else {
                                return 0;
                            }
                        }

                    }
                    else if (number!=ASCII_SPACE){
                        stringBuilder.append((char)number);
                    }
                }
            }
        if (!stringBuilder.toString().equals("")) {
            return Integer.valueOf(stringBuilder.toString());
        } else {
            return 0;
        }
        }catch (NumberFormatException e){
            //int is out of the range
            if (stringBuilder.toString().equals("-") || stringBuilder.toString().equals("+")){
                return 0;
            }
            if (minus){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
