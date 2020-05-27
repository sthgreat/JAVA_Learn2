package NiukeReal;

import java.util.*;
import java.lang.*;
import java.io.*;

/***
 * 利用二分法解题
 */
public class 牛牛的闹钟 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] time = new int[count];
        for(int i = 0;i<count;i++){
            int hour = sc.nextInt();
            int min = sc.nextInt();
            time[i] = 60 * hour + min;
        }
        int costTime = sc.nextInt();
        int arriveTime = sc.nextInt() * 60 + sc.nextInt();
        int shouldTime = arriveTime - costTime;
        Arrays.sort(time);

        int left = 0;
        int right = count - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(time[mid] < shouldTime){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(time[left] == shouldTime){
            System.out.println(deal(time[left]));
        }else if(time[left] > shouldTime){
            while(time[left] > shouldTime && left > 0 ){
                left -= 1;
            }
            System.out.println(deal(time[left]));
        }else{
            while(time[left] < shouldTime && left < count - 1){
                left += 1;
            }
            System.out.println(deal(time[left - 1]));
        }
    }

    public static String deal(int time){
        int min = time % 60;
        int hour = time / 60;
        StringBuilder sb = new StringBuilder();
        sb.append(hour).append(" ").append(min);
        return sb.toString();
    }
}
