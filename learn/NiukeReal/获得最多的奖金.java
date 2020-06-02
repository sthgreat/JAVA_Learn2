package NiukeReal;

import java.util.*;

/***
 * 使用双指针
 */
public class 获得最多的奖金 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] redBag = new int[n];
        for(int i = 0;i<n;i++){
            redBag[i] = sc.nextInt();
        }
        int start = 1;
        int end = redBag.length - 1;
        long part1 = redBag[0];
        long part3 = 0;
        long ans = 0;
        while(start <= end){
            if(part1 < part3){ //左侧要多切
                part1 += redBag[start ++];
            }else if(part1 > part3){
                part3 += redBag[end --];
            }else{
                ans = part1;
                part1 += redBag[start ++];
            }
        }
        if(part1 == part3){
            ans = part1;
        }
        System.out.print(ans);
    }
}
