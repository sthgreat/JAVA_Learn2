package LeetCode;

public class 回文子串_647 {
    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0;i<s.length();i++){
            for(int j = 0;j<=i;j++){
                if(j == i){//长度为1
                    dp[j][i] = true;
                    ans ++;
                }else if(i - 1 == j && s.charAt(i) == s.charAt(j)){ //长度为2
                    dp[j][i] = true;
                    ans ++;
                }else{
                    if(dp[j + 1][i - 1] && s.charAt(i) == s.charAt(j)){
                        dp[j][i] = true;
                        ans ++;
                    }
                }
            }
        }
        return ans;
    }
}
