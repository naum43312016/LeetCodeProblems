package naum.asafov.com.MinimumWindowSubstring76;

import java.util.*;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
 */
public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        int matched = 0;
        boolean found = false;
        Map<Character, Integer> currentSpan = new HashMap<>();
        Map<Character, Integer> desiredSpan = toSpan(t);
        Queue<Integer> queue = new LinkedList<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (desiredSpan.keySet().contains(c)) {
                queue.add(end);
                addToSpan(currentSpan, c);
                if (currentSpan.get(c) <= desiredSpan.get(c)) {
                    matched++;
                }
            }

            while (matched == t.length()) {
                found = true;
                start = queue.poll();
                if ((end - start) < min) {
                    minStart = start;
                    minEnd = end;
                    min = (end - start);
                }
                char sc = s.charAt(start);
                removeFromSpan(currentSpan, sc);
                if (!currentSpan.containsKey(sc) || currentSpan.get(sc) < desiredSpan.get(sc)) {
                    matched--;
                }
            }
            end++;
        }
        return found ? s.substring(minStart, minEnd + 1) : "";
    }

    private void addToSpan(Map<Character, Integer> span, char c) {
        Integer count = span.get(c);
        if (count == null) {
            span.put(c, 1);
        } else {
            span.put(c, count + 1);
        }
    }

    private void removeFromSpan(Map<Character, Integer> span, char c) {
        int count = span.get(c);
        count -= 1;
        if (count == 0) {
            span.remove(c);
        } else {
            span.put(c, count);
        }
    }

    private Map<Character, Integer> toSpan(String t) {
        Map<Character, Integer> span = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            addToSpan(span, t.charAt(i));
        }
        return span;
    }
}
