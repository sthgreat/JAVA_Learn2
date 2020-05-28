package NiukeReal;

import java.io.*;
import java.lang.*;
import java.util.*;

public class 俄罗斯方块 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        int count = sc.nextInt();
        int[] record = new int[column];
        for(int i = 0;i<count;i++){
            record[sc.nextInt() - 1] += 1;
        }
        int min = record[0];
        for(int i = 0;i<record.length;i++){
            min = Math.min(record[i], min);
        }
        System.out.println(min);
    }
}