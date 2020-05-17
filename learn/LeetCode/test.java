package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test {
    public static void main(String[] args){
        test t = new test();
        List<String> l = new ArrayList<>();
        l.add("leet");
        l.add("code");
        t.wordBreak("leetcode", l);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0){
            return false;
        }
        HashSet<String> set = new HashSet<>();
        boolean[] list = new boolean[s.length() + 1];
        for(String word : wordDict){
            set.add(word);
        }
        list[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(list[j] && set.contains(s.substring(j,i))){
                    list[i] = true;
                    break;
                }
            }
        }
        return list[s.length() - 1];
    }
}