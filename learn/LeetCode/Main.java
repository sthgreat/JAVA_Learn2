package LeetCode;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = Integer.parseInt(sc.nextLine());
            for(int i = 0;i<num;i++){
                String s = sc.nextLine();
                String ans = deal(s);
                System.out.println(ans);
            }
        }
    }

    public static String deal(String s){
        char[] st = new char[s.length()];
        int count = 0; //当前的最后一个
        for(int i = 0;i<s.length();i++){
            if(count - 1 >= 0 && s.charAt(i) == st[count - 1]){
                if(count - 2 >= 0 && st[count - 2] == st[count-1]){
                    continue;//略去重复的字节
                }
                if(count - 4 >= 0 && st[count-4] == st[count - 3]){ //处理AABB
                    continue; //略去重复字节
                }
                st[count ++] = s.charAt(i);
            }else{
                st[count ++] = s.charAt(i);
            }
        }
        return new String(st).trim();
    }
}