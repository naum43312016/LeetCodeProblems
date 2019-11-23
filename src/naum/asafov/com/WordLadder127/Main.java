package naum.asafov.com.WordLadder127;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int i  = new Solution().ladderLength(beginWord,endWord,wordList);
        System.out.println(i);
    }
}


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = findLadders(beginWord,endWord,wordList);
        int max = 0;
        for (List<String> l : list){
            max = Math.max(max,l.size());
        }
        return max;
    }
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