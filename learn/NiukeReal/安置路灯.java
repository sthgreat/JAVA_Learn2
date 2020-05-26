package NiukeReal;

import java.util.*;
import java.lang.*;
import java.io.*;

/***
 * 每一行，从“.”开始计数，凡是出现一个“.”，可以往前前进3格，这三格分配一个路灯
 */
public class 安置路灯 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int castCount = sc.nextInt();
        for(int i = 0;i<castCount;i++){
            int ans = 0;
            int posNum = sc.nextInt();
            String str = sc.next();
            int k = 0;
            while(k < posNum){
                if(str.charAt(k) == '.'){
                    k += 3;
                    ans += 1;
                }else{
                    k++;
                }
            }
            System.out.println(ans);
        }

    }
}
