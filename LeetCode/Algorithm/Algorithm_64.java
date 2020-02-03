class Solution {
    public int minPathSum(int[][] grid) {
        for(int count = 1;count<grid[0].length;count++){
            grid[0][count] += grid[0][count - 1];
        }
        for(int count = 1;count<grid.length;count++){
            grid[count][0] += grid[count - 1][0];
        }

        if(grid[0].length == 1 || grid.length == 1){
            return grid[0][grid[0].length - 1];
        }

        for(int i = 1;i<grid.length;i++){
            for(int j = 1;j<grid[0].length;j++){
                int leftNum = grid[i][j - 1] + grid[i][j];
                int upNum = grid[i - 1][j] + grid[i][j];
                grid[i][j] = leftNum <= upNum ? leftNum : upNum;
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];

    }
}