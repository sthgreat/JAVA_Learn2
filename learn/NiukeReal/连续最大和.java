package NiukeReal;

import java.util.*;

/***
 * dp是一个当前最大值的记录数组
 * 当dp[i-1]+num[i] < num[i]的时候，意味着dp[i-1]对dp[i]是负贡献，不能加入
 */
public class 连续最大和 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[size + 1];
        int ans = arr[0];
        for(int i = 1;i<=size;i++){
            dp[i] = Math.max(dp[i - 1] + arr[i - 1], arr[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        System.out.print(ans);
    }
}
