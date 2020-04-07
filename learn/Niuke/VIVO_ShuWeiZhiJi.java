package Niuke;

import java.util.*;

/***
 * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
 */

public class VIVO_ShuWeiZhiJi {
    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    static LinkedList<Integer> result = new LinkedList<>();
    static boolean flag = true;
    public int solution (int n) {
        // write code here
        perm(n);
        if(flag == false || result.size() == 0){
            return -1;
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = result.size() - 1; i>=0;i--){
                sb.append(result.get(i));
            }
            return Integer.parseInt(sb.toString());
        }
    }

    static void perm(int n){
        if(n < 10){
            result.add(n);
            return;
        }else{
            for(int i = 9;i>1;i--){
                if((n % i) == 0){
                    result.add(i);
                    perm(n / i);//找最大的
                    return;
                }
            }
            flag = false;
            return;
        }
    }

}