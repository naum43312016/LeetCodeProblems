package naum.asafov.com.countandsay;

public class Main {
    public static void main(String[] args) {
        String s = countAndSay(2);
        System.out.println(s);
    }

    public static String countAndSay(int n) {
        String s = "1"; // base
        for (int i = 1; i < n; i++) { // build the numbers from 1 to n
            s = nextNumber(s);
        }
        return s; // return result
    }

    private static String nextNumber(String s) { // our helper method
        StringBuilder result = new StringBuilder(); // create new StringBuilder
        for (int i = 0; i < s.length(); i++) { // take in previous # and prepare to run across it
            int count = 1; // initialize how many times we've seen a #
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) { // while we don't run off the end
                // and we're still on the same #
                i++; // increment our pointer
                count++; // increment how many times we've seen that #
            }
            result.append(count).append(s.charAt(i)); // and append the count and then the #
        }
        return result.toString(); // and finally return
    }
}