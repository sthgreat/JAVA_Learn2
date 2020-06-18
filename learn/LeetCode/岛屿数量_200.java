package LeetCode;

public class 岛屿数量_200 {
    public void dfs(int i, int j, char[][] matrix){
        if(i < 0 || i >=matrix.length || j <0 || j>=matrix[0].length){
            return;
        }
        if(matrix[i][j] == '0'){
            return;
        }

        matrix[i][j] = '0';
        dfs(i-1,j,matrix);
        dfs(i+1,j,matrix);
        dfs(i,j-1,matrix);
        dfs(i,j+1,matrix);
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    ans ++;
                }
            }
        }

        return ans;
    }

}
