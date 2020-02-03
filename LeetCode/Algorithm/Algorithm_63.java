class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid.length;
        int row = obstacleGrid[0].length;
        int[][] net = new int[col][row];

        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        net[0][0] = 1;
        for(int i = 0;i<col;i++){
            for(int j = 0;j<row;j++){
                if(i == 0 && j == 0){
                    continue; //跳过初始
                }
                if(obstacleGrid[i][j] == 1){
                    net[i][j] = 0;
                    continue;
                }
                if(i == 0){
                    net[i][j] = net[i][j - 1];
                }else if(j == 0){
                    net[i][j] = net[i - 1][j];
                }else{
                    net[i][j] = net[i - 1][j] + net[i][j - 1];
                }
            }
        }
        return net[col - 1][row - 1];
    }
}