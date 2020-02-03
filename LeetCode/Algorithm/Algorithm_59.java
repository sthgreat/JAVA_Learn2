class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] result = new int[n][n];

        int num = 1;
        int tar = n*n;
        while(num <= tar){
            for(int i = left;i<=right;i++){  //左到右
                result[top][i] = num ++;
            }
            top ++ ;
            for(int i = top; i <= bottom ; i++){
                result[i][right] = num++;
            }
            right -- ;
            for(int i = right; i>= left; i--){
                result[bottom][i] = num++;
            }
            bottom -- ;
            for(int i = bottom; i>= top;i--){
                result[i][left] = num++;
            }
            left ++ ;
        }
        return result;
    }
}