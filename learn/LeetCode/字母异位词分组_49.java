package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * 使用质数计算字符串的哈希值，哈希值相同的字符串拥有相同的字母
 */
public class 字母异位词分组_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] array = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};
        HashMap<Long, List<String>> map = new HashMap<>();
        for(String s : strs){
            Long hashValue = 1L;
            for(int i = 0;i<s.length();i++){
                hashValue *= Long.valueOf(array[s.charAt(i)-'a']);
            }
            if(!map.containsKey(hashValue)){
                ArrayList<String> arr = new ArrayList<>();
                arr.add(s);
                map.put(hashValue, arr);
            }else{
                map.get(hashValue).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}