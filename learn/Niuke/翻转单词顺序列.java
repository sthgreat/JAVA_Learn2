package Niuke;

import java.util.*;

/***
 * 因为是按照空格划分的string数组，因此需要注意" "情况
 */
public class 翻转单词顺序列 {
    public String ReverseSentence(String str) {
        if(str.length()==0){
            return str;
        }
        String[] line = str.split(" ");
        if(line.length == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = line.length - 1;i>=0;i--){
            if(i == 0){
                sb.append(line[i]);
            }else{
                sb.append(line[i]).append(" ");
            }
        }
        return sb.toString();
    }
}