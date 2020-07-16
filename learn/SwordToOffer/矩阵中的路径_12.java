package SwordToOffer;

public class 矩阵中的路径_12 {
    public boolean exist(char[][] board, String word) {

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j]){
                    if(check(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int i , int j,String word, int k){
        if(k >=word.length() || i <0 || i >= board.length || j<0 || j>=board[0].length || word.charAt(k) != board[i][j]){
            return false;
        }
        if(k == word.length() - 1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = (check(board, i-1,j,word,k+1) || check(board, i+1,j,word,k+1) || check(board, i,j-1,word,k+1) || check(board, i,j+1,word,k+1));
        board[i][j] = temp;

        return res;
    }
}
