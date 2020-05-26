package NiukeReal;

import java.util.*;
import java.lang.*;
import java.io.*;

/***
 * 固定一个除数，对于一个除数y来说，x % y会在0,1,2,...,y-1间循环
 * x / y算出有多少个循环 i，再算出一个循环中符合条件的数对个数 j，ans += i * j
 * 最后处理多出来的不满一个循环中的正确答案
 * x % y 得到多出循环多少，即为 1, 2, ... , x % y，统计其中符合条件的数对j'
 * ans += j'
 */
public class 数对 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long k = sc.nextInt();
        long ans = 0;
        boolean flag = true;
        if(k == 0){
            System.out.println(n * n);
            flag = false;
        }
        for(int i = 1; i<= n;i++){
            if(i - 1>=k){
                ans += (n/i)*(i-k);
                long kkk = n % i;
                if(kkk - k >= 0){
                    ans += (kkk - k + 1);
                }
            }
        }
        if(flag){
            System.out.println(ans);
        }
    }
}
