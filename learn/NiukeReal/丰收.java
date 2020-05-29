package NiukeReal;

import java.util.*;
import java.io.*;
import java.lang.*;

/***
 * 使用二分法进行判断，注意题目中判断次数过多也会超时
 */
public class 丰收 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalCount = sc.nextInt();
        int[] a = new int[totalCount];
        for(int i = 0;i<totalCount;i++){
            if(i == 0){
                a[0] = sc.nextInt();
            }else{
                a[i] = a[i - 1] + sc.nextInt();
            }
        }

        int qCount = sc.nextInt();
        for(int i = 0;i<qCount;i++){
            int b = sc.nextInt(); //第几个苹果
            find(b, a);
        }
    }

    public static void find(int b, int[] a){
        int start = 0;
        int end = a.length - 1;
        if(b <= a[0]){
            System.out.println(1);
            return;
        }
        while(start < end){
            int mid = (start + end) >>>1;
            if(a[mid] < b){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        if(b > a[start]){
            System.out.println(start + 2);
        }else{
            System.out.println(start + 1);
        }
    }
}