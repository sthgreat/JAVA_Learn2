package LeetCode;

import java.util.*;

/***
 * 效率不高，建议用字符串指针来代替切割字符串
 */
public class 分割回文串_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        LinkedList<String> record = new LinkedList<>();
        cut(record, ans, s);

        return ans;
    }

    public void cut(LinkedList<String> record, List<List<String>> ans, String s){
        System.out.println(s.length());
        if(s.length() == 1){
            LinkedList<String> temp = new LinkedList<>(record);
            temp.add(s);
            ans.add(temp);
            return;
        }
        if(s.length() == 0){
            LinkedList<String> temp = new LinkedList<>(record);
            ans.add(temp);
            return;
        }

        for(int i = 1; i<=s.length();i++){
            String sub = s.substring(0, i);
            if(isOk(sub)){
                record.add(sub);
                cut(record, ans, s.substring(i));
                record.removeLast();
            }
        }
    }

    public boolean isOk(String s){//判断是否是回文串
//        System.out.println(s);
        if(s.length() == 1){
            return true;
        }
        for(int i = 0; i <= s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
