package LeetCode;

import java.util.ArrayList;

public class 计算二进制子串_696 {
    public int countBinarySubstrings(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int c = 0;
        int count = 0;
        char start = s.charAt(0);
        while(c < s.length()){
            if(s.charAt(c) == start){
                count ++;
            }else{
                list.add(count);
                count = 1;
                start = s.charAt(c);
            }
            c ++;
        }
        list.add(count);
        int ans = 0;
        for(int i = 0;i<list.size() - 1;i++){
            ans += Math.min(list.get(i),list.get(i + 1));
        }
        return ans;
    }
}
