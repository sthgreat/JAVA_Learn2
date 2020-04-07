package Niuke;

import java.util.*;


public class test2 {
    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    static LinkedList<Integer> result = new LinkedList<>();
    static boolean flag = true;

    public static void main(String[] args){
        test2 t = new test2();
        System.out.println(t.solution(100));
    }

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