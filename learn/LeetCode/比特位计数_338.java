package LeetCode;

public class 比特位计数_338 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if(num == 0){
            return dp;
        }else if(num == 1){
            dp[1] = 1;
            return dp;
        }
        dp[0] = 0;
        dp[1] = 1;
        int count = 2;
        int flag = 0;
        for(int i = 2;i<=num;i++){
            if(flag < count){
                dp[i] = dp[i - count] + 1;
            }else{
                flag = 0;
                count *= 2;
                dp[i] = dp[i - count] + 1;
            }
            flag ++;

        }
        return dp;
    }
}
