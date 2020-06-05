package LeetCode;

import java.util.HashMap;

public class Z字形变换_6 {
    public String convert(String s, int numRows) {
        if(s.length() == 0){
            return "";
        }
        if(numRows == 1){
            return s;
        }
        int r = 1;
        HashMap<Integer, String> map = new HashMap<>();
        boolean flag = true; //true时递增，false时递减
        for(int i = 0;i<s.length();i++){
            add(map, i, r,s);
            if(r == numRows){
                flag = false;
            }else if(r == 1){
                flag = true;
            }
            if(flag){
                r++;
            }else{
                r--;
            }
        }
        String ans = "";
        numRows = Math.min(s.length(), numRows);
        for(int i = 1;i<=numRows;i++){
            ans += map.get(i);
        }
        return ans;
    }

    public static void add(HashMap<Integer, String> map, int cur, int h, String s){
        if(!map.containsKey(h)){
            map.put(h, s.charAt(cur) + "");
        }else{
            map.put(h, map.get(h) + s.charAt(cur));
        }
    }
}
