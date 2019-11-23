package naum.asafov.com.SortCharactersByFrequency451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        String ans = new Solution().frequencySort("tree");
        System.out.println(ans);
    }
}
class Solution {
    public String frequencySort(String s) {
        if (s==null || s.length()==0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();

        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }

        Map<Character, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));

        ArrayList<Character> keys = new ArrayList<Character>(sorted.keySet());
        for(int i=keys.size()-1; i>=0;i--){
            for (int j=0;j<map.get(keys.get(i));j++){
                res.append(keys.get(i));
            }
        }

        return res.toString();
    }
}