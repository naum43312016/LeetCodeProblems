package naum.asafov.com.IsomorphicStrings205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String s = "gpp", t = "aco";

        System.out.println(new Solution().isIsomorphic(s,t));
    }
}
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s==null || t==null){
            return false;
        }
        if(s.length()==0 && t.length()==0) return true;

        Map<Character,Character> set = new HashMap();

        StringBuilder ans = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (set.containsKey(s.charAt(i))){
                ans.append(set.get(s.charAt(i)));
            }else {
                if (set.containsValue(t.charAt(i))){
                    return false;
                }
                ans.append(t.charAt(i));
                set.put(s.charAt(i),t.charAt(i));
            }
        }

        if (ans.toString().equals(t)){
            return true;
        }

        return false;
    }
}