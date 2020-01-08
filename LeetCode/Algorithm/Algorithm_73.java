class Solution {
    public void setZeroes(int[][] matrix) {
        int[] col = new int[matrix.length];
        int[] row = new int[matrix[0].length];

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    col[i] = 1;
                    row[j] = 1;
                }
            }
        }
        for(int i = 0; i<col.length;i++){
            if(col[i] == 1){
                for(int j = 0;j<matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j<row.length;j++){
            if(row[j] == 1){
                for(int i = 0;i<matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}