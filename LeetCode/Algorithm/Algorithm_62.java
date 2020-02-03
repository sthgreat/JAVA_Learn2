class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int[][] net = new int[n][m];
        for(int row = 0; row < m; row++){
            net[0][row] = 1;
        }
        for(int column = 0;column<n;column++){
            net[column][0] = 1;
        }
        for(int i = 1; i < n;i++){
            for(int j = 1; j< m;j++){
                net[i][j] = net[i - 1][j] + net[i][j-1];
            }
        }
        return net[n - 1][m - 1];
    }
}