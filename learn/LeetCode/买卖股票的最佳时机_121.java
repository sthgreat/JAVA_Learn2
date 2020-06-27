package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

/***
 * 动态规划
 */
public class 买卖股票的最佳时机_121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        // dp：当前天数所能拥有的最大值，1代表还剩一次，0代表无剩余次数，1代表持有，0代表未持有
        int[][][] dp = new int[prices.length][2][2];
        dp[0][0][1] = - prices[0];
        dp[0][1][0] = 0;
        dp[0][0][0] = -Integer.MIN_VALUE;
        dp[0][1][1] = -Integer.MIN_VALUE;
        int max = 0;
        for(int i = 1;i<prices.length;i++){
            dp[i][1][0] = dp[i - 1][1][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] - prices[i]);
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1] + prices[i]);
            if(dp[i][0][0] > max){
                max = dp[i][0][0];
            }
        }

        return max;
    }
}
