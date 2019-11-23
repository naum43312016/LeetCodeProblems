package naum.asafov.com.DecodeString394;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 */
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {

    public String decodeString(String s) {
        return decodeString(s, 0, s.length()-1);
    }

    private static String decodeString(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i=start; i<=end;) {
            if (isAlphabet(arr[i])) {
                sb.append(arr[i]);
                i++;
            } else {
                int num = 0;
                while (arr[i] != '[') {
                    num = (num * 10) + (arr[i] - '0');
                    i++;
                }
                int openLeftCount = 1;
                i++;
                int t1 = i;
                while (i < arr.length) {
                    if (arr[i] == '[') {
                        openLeftCount++;
                    } else if (arr[i] == ']') {
                        openLeftCount--;
                    }
                    i++;
                    if(openLeftCount == 0) {
                        String decodedString = decodeString(s, t1, i-2);
                        for (int j=1; j<=num; j++) {
                            sb.append(decodedString);
                        }
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    private static boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
