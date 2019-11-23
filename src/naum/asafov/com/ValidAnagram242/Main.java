package naum.asafov.com.ValidAnagram242;

public class Main {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new Solution().isAnagram(s,t));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] sc =  s.toCharArray();
        char[] tc =  t.toCharArray();

        for (int i=0;i<sc.length;i++){
            boolean f = false;
            for (int j=0;j<tc.length;j++){
                if (sc[i]==tc[j]){
                    f=true;
                    tc[j]='0';
                    break;
                }
            }
            if (!f){
                return false;
            }
        }

        return true;
    }
}