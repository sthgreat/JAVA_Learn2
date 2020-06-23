package LeetCode;

/***
 * 动态代理
 */
public class 最佳卖卖股票的时机含冷冻期_309 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        //dp[i][j] i:当前是第几天，j：当前是否持有股票（1：是，0：否）
        int[][] dp = new int[prices.length][2];
        for(int i = 0;i<prices.length;i++){
            if(i == 0){
                dp[i][1] = - prices[0];
                dp[i][0] = 0;
            }else if(i == 1){
                dp[i][1] = Math.max(dp[0][1], -prices[1]);
                dp[i][0] = Math.max(prices[1] - prices[0], dp[i -1][0]);
            }else{
                dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
                dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            }
        }
        return dp[prices.length - 1][0];
    }
}
