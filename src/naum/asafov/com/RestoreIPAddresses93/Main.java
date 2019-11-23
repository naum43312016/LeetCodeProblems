package naum.asafov.com.RestoreIPAddresses93;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = new Solution().restoreIpAddresses(s);
        System.out.println(list.toString());
    }
}

class Solution {
    public List<String> restoreIpAddresses(String s) {
        return helper(s, 4);
    }

    public List<String> helper(String s, int numSlots) {
        ArrayList<String> result = new ArrayList<>();
        if (numSlots == 1) {
            if (s.length() > 0 && s.length() <= 3 && Integer.parseInt(s) <= 255 &&
                    (s.length() == 1 || s.charAt(0) != '0')) {
                result.add(s);
            }
            return result;
        }
        if (s.length() > 1) {
            for (String child : helper(s.substring(1), numSlots - 1)) {
                result.add(s.substring(0, 1) + "." + child);
            }
        }
        if (s.length() > 2 && s.charAt(0) != '0') {
            for (String child : helper(s.substring(2), numSlots - 1)) {
                result.add(s.substring(0, 2) + "." + child);
            }
        }
        if (s.length() > 3 && s.charAt(0) != '0') {
            if (Integer.parseInt(s.substring(0, 3)) <= 255) {
                for (String child : helper(s.substring(3), numSlots - 1)) {
                    result.add(s.substring(0, 3) + "." + child);
                }
            }
        }
        return result;
    }
}