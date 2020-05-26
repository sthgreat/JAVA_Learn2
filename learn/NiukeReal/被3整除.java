package NiukeReal;

import java.util.*;
import java.io.*;
import java.lang.*;

/***
 * 一个数如何被3整除？
 * 加起来的数能被3整除
 * 常规方法会超时间，找规律发现每3个数字都有两个可以被整除
 */
import java.util.*;
import java.io.*;
import java.lang.*;

public class 被3整除 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();

        long a = 2 * ((left - 1) / 3);
        if((left - 1) % 3 == 2){
            a += 1;
        }
        long b = 2 * (right / 3);
        if(right % 3 == 2){
            b += 1;
        }
        System.out.println(b - a);

    }
}
