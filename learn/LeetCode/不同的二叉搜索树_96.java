package LeetCode;

/***
 * 使用动态规划的思想，需要注意的是种类个数只与所取得的长度有关
 */
public class 不同的二叉搜索树_96 {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int k = 1;k<=i;k++){
                G[i] += G[k - 1] * G[i - k];
            }
        }
        return G[n];
    }
}
