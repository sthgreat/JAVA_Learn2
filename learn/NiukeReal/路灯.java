package NiukeReal;

import java.util.*;
import java.text.*;

public class 路灯 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int len = sc.nextInt();
        int[] pos = new int[num];
        for(int i = 0;i<num;i++){
            pos[i] = sc.nextInt();
        }
        Arrays.sort(pos);
        int wideMax = Integer.MIN_VALUE;
        for(int i = 0;i<num;i++){
            if(i == 0){
                wideMax = Math.max(wideMax, pos[i]);
            }else{
                wideMax = Math.max(wideMax, pos[i] - pos[i-1]);
            }
        }
        wideMax = Math.max(wideMax, len - pos[pos.length - 1]);
        double ans = Double.valueOf(String.valueOf(wideMax));
        System.out.print(String.format("%.2f", ans / 2));
    }
}
