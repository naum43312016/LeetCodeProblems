package naum.asafov.com.WordLadderII126;

import java.util.*;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

 */
public class Main {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> list = new Solution().findLadders(beginWord,endWord,wordList);
        System.out.println(list.toString());
    }
}


class Solution {
    public List<String> generatePotentials(String beginWord, Set<String> wordList) {
        List<String> list = new ArrayList<>();
        char[] chars = beginWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char o = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == o) {
                    continue;
                }
                chars[i] = c;
                String newWord = new String(chars);
                if (wordList.contains(newWord)) {
                    list.add(newWord);
                }
            }
            chars[i] = o;
        }
        return list;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        start.add(beginWord);
        dict.removeAll(start); // the dict contains the beginWord, remove the loop

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        while(!start.isEmpty()) {
            if (start.contains(endWord)) {
                break;
            }
            Set<String> set = new HashSet<>();
            for (String w : start) {
                List<String> po = generatePotentials(w, dict);
                if (!po.isEmpty()) {
                    map.put(w, po);
                    set.addAll(po);
                }
            }
            dict.removeAll(set);
            start = set;
        }
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        dfs(beginWord, endWord, map, res, temp);
        return res;
    }

    public void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> temp) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (map.containsKey(beginWord)) {
            for (String w : map.get(beginWord)) {
                temp.add(w);
                dfs(w, endWord, map, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}