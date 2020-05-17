package LeetCode;

import java.util.*;

/***
 * 动态规划的思想
 */
public class 单词拆分_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0){
            return false;
        }
        HashSet<String> set = new HashSet<>();
        boolean[] list = new boolean[s.length()];
        for(String word : wordDict){
            set.add(word);
        }
        if(set.contains(s.substring(0, 1))){
            list[0] = true;
        }
        for(int i = 1;i<s.length();i++){
            for(int j = 0;j<i;j++){
                if(list[j] && set.contains(s.substring(j + 1,i + 1))){
                    list[i] = true;
                    break;
                }
            }
        }
        return list[s.length() - 1];
    }
}
