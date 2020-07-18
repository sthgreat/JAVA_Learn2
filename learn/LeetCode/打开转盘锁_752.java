package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;

public class 打开转盘锁_752 {
    public String up(String s, int j){
        char[] charArr = s.toCharArray();
        if(charArr[j] == '9'){
            charArr[j] = '0';
        }else{
            charArr[j] += 1;
        }
        return new String(charArr);
    }

    public String down(String s, int j){
        char[] charArr = s.toCharArray();
        if(charArr[j] == '0'){
            charArr[j] = '9';
        }else{
            charArr[j] -= 1;
        }
        return new String(charArr);
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        for(String s : deadends){
            dead.add(s);
        }
        if(dead.contains("0000")){
            return -1;
        }
        int ans = 0;
        String ss = "0000";
        LinkedList<String> list = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        list.add("0000");
        while(list.size() > 0){
            for(int i = list.size(); i>0;i--){
                String num = list.removeFirst();
                if(num.equals(target)){
                    return ans;
                }
                for(int j = 0;j<4;j++){
                    String upS = up(num, j);
                    String downS = down(num, j);
                    if(!visited.contains(upS) && !dead.contains(upS)){
                        visited.add(upS);
                        list.addLast(upS);
                    }
                    if(!visited.contains(downS) && !dead.contains(downS)){
                        visited.add(downS);
                        list.addLast(downS);
                    }
                }
            }
            ans ++;
        }
        return -1;
    }
}
