package LeetCode;

import java.util.LinkedList;

public class 翻转字符串里的单词_151 {
    public String reverseWords(String s) {
        int start = 0;
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                String temp = s.substring(start, i);
                if(temp.length() > 0){
                    list.add(temp);
                }
                start = i + 1;
            }
        }
        list.add(s.substring(start).trim());
        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()){
            sb.append(list.removeLast()).append(" ");
        }
//        for(int i = 0;i<list.size();i++){
//            sb.append(list.removeLast()).append(" ");
//        }
        return sb.toString().trim();
    }
}
