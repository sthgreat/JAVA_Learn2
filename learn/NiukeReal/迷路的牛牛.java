package NiukeReal;

import java.util.*;
import java.lang.*;
import java.io.*;

/***
 *
 *
 */
public class 迷路的牛牛 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String s = sc.next();
        int leftCount = 0;
        int RightCount = 0;
        for(int i = 0; i<count;i++){
            if(s.charAt(i) == 'L'){
                leftCount ++;
            }else{
                RightCount ++;
            }
        }
        int turn = leftCount - RightCount;
        boolean flag = false;
        if(turn < 0){
            turn = -turn;
            flag = true;
        }
        int real = turn % 4;
        if(real == 0){
            System.out.println("N");
        }else if(real == 2){
            System.out.println("S");
        }else if(real == 1){
            if(flag){
                System.out.println("E");
            }else{
                System.out.println("W");
            }
        }else if(real == 3){
            if(flag){
                System.out.println("W");
            }else{
                System.out.println("E");
            }
        }
    }
}

