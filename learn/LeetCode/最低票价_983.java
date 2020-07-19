package LeetCode;

public class 最低票价_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        for(int i : days){
            dp[i] = 1;
        }
        for(int i = 1;i<366;i++){
            if(dp[i] == 0){ //当前不需要出行
                dp[i] = dp[i - 1];
            }else{
                int cost1 = costs[0] + dp[i - 1];
                int cost2 = 0;
                int cost3 = 0;
                if(i - 7 >= 0){
                    cost2 = costs[1] + dp[i - 7];
                }else{
                    cost2 = costs[1];
                }
                if(i - 30 >= 0){
                    cost3 = costs[2] + dp[i - 30];
                }else{
                    cost3 = costs[2];
                }
                dp[i] = Math.min(cost1, cost2);
                dp[i] = Math.min(dp[i], cost3);
            }
        }
        return dp[365];
    }
}
