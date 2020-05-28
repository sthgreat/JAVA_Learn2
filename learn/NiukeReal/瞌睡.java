package NiukeReal;

import java.lang.*;
import java.util.*;

/***
 * AC 90%，超时
 */
public class 瞌睡 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int lastTime = sc.nextInt();
        int weekTime = sc.nextInt();
        int[] intersting = new int[lastTime];
        int[] isAwake = new int[lastTime];
        for(int i = 0;i<lastTime;i++){
            intersting[i] = sc.nextInt();
        }
        for(int i = 0;i<lastTime;i++){
            isAwake[i] = sc.nextInt();
        }
        long max = 0;
        long noAwakePoint = 0;
        for(int i = 0;i<lastTime;i++){
            noAwakePoint += (intersting[i] * isAwake[i]);
        }
        max = noAwakePoint;
        for(int i = 0;i<lastTime;i++){
            if(isAwake[i] == 0){
                long value = noAwakePoint;
                int j = i;
                while(j < i+weekTime && j<lastTime){
                    if(isAwake[j] == 0){
                        value += intersting[j];
                    }
                    j++;
                }
                if(value > max){
                    max = value;
                }
            }
        }
        System.out.println(max);
    }
}