package NiukeReal;

import java.util.*;
public class 连续子数组的最大和 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int totalNum = sc.nextInt();
            int[] arr = new int[totalNum];
            for(int i = 0;i<totalNum;i++){
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[totalNum];
            dp[0] = arr[0];
            int ans = dp[0];
            for(int i = 1;i<totalNum;i++){
                dp[i] = (dp[i - 1] + arr[i] > 0) ? dp[i - 1] + arr[i] : 0;
                ans = Math.max(dp[i], ans);
            }
            System.out.println(ans);
        }
    }
}
