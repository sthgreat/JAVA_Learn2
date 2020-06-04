package NiukeReal;

import java.util.*;

/***
 * 查询使用哈希的方式进行检索，要注意每一行不一定都能全部塞满
 */
public class 一封奇怪的信 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine();
        String s = sc.nextLine();
        String[] record = l.split(" ");
        int totalLength = 0;
        int h =0;
        for(int i = 0;i<s.length();i++){
            int add = Integer.valueOf(record[s.charAt(i) - 'a']);
            if(totalLength + add > 100){ //换行
                h ++;
                totalLength = add;
            }else{
                totalLength += add;
            }
        }
        System.out.println(h + 1 + " " + totalLength);
    }
}
