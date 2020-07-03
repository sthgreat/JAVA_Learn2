package NiukeReal;

import java.util.*;

/***
 * 抓捕孔连顺，ac 70%，超时
 */
public class 万万没想到之抓捕孔连顺 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long ans = 0;
            int buildingNum = sc.nextInt();
            int max = sc.nextInt();
            int[] arr = new int[buildingNum];
            for(int i =0;i<buildingNum;i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 2;i<arr.length;i++){
                for(int j = i - 2 ;j>=0;j--){
                    if(arr[i] - arr[j] > max){
                        break;
                    }
                    ans += (i - j - 1);
                }
            }
            System.out.println(ans % 99997867);
        }
    }
}
