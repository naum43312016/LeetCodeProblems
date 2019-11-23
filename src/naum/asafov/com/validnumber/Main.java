package naum.asafov.com.validnumber;

/*
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
 */
public class Main {
    public static void main(String[] args) {
        String s = "-90e3";


    }
}

class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() < 1) return false;
        boolean gotNumber = false, gotE = false, gotSigned = false, gotDot = false, gotSpace = false, everGotNum = false;
        while(s.charAt(0) == ' ' && s.length() > 1) {//ybiraet probeli iz na4ala
            s = s.substring(1);
        }
        while(s.charAt(s.length() - 1) == ' ' && s.length() > 1) {//yberaet probeli s konca
            s = s.substring(0, s.length() - 1);
        }
        String temp = s;
        if(temp.length() == 1) return temp.charAt(0) >= '0' && temp.charAt(0) <= '9';
        if((temp.charAt(0) > '9' || temp.charAt(0) < '0') && temp.charAt(0) != '-' && temp.charAt(0) != '+' && temp.charAt(0) != '.') return false;
        if((temp.charAt(temp.length() - 1) > '9' || temp.charAt(temp.length() - 1) < '0') && temp.charAt(temp.length() - 1) != '.') return false;
        for(int i = 0; i < temp.length(); i++) {
            char cur = temp.charAt(i);
            if(cur >= '0' && cur <= '9') {everGotNum = true;gotNumber = true;}
            else if(gotDot && !gotE && (cur == '+' || cur == '-')) return false;
            else if(!gotSigned && (cur == '-' || cur =='+') && !gotNumber) gotSigned = true;
            else if(gotNumber && (cur == '+' || cur == '-')) return false;
            else if(gotSigned && (cur == '-' || cur =='+')) return false;

            else if(cur == ' ') return false;

            else if(!gotNumber && (cur >= 'a' && cur <= 'z' || cur >= 'A' && cur <= 'Z') && cur != '.') return false;

            else if(!gotE && gotNumber && cur == 'e') {gotE = true;gotSigned = false;gotNumber = false;}

            else if(!gotNumber && cur == 'e') return false;
            else if(gotE && cur == 'e') return false;

            else if(gotNumber && (cur >= 'a' && cur <= 'z' || cur >= 'A' && cur <= 'Z') && cur != 'e') return false;

            else if(!gotDot && cur == '.' && !gotE) gotDot = true;
            else if(gotDot && cur == '.') return false;

            else if(gotE && (cur < '0' || cur > '9')) return false;
            else if(gotE && cur == '.') {
                return false;
            }
        }
        if(!everGotNum) return false;
        return true;
    }
}
