package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class 子串的最大出现次数_1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = minSize - 1;i<s.length();i++){
            String s1 = s.substring(i - minSize + 1, i+1);
            if(check(s1, maxLetters)){
                if(map.get(s1) == null){
                    map.put(s1, 1);
                }else{
                    map.put(s1, map.get(s1) + 1);
                }
            }
        }
        int ans = 0;
        for(String key : map.keySet()){
            ans = Math.max(ans, map.get(key));
        }
        return ans;
    }

    public boolean check(String s, int max){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            set.add(s.charAt(i));
            if(set.size() > max){
                return false;
            }
        }
        return true;
    }
}
