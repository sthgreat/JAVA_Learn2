package LeetCode;

/***
 * 考虑回返情况不能算在内
 */
public class Test {
    public static void main(String[] args){
        char[][] a = new char[][]{{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
        Test t = new Test();
        System.out.println(t.exist(a, "aaaaaaaaaaaaa"));
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(i,j,board,word,0,"head")){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean find(int r, int c, char[][] board, String word, int index,String front){//r:行,c:列
        if(index == word.length() - 1){
            return true;
        }
        char top = r-1>=0 ? board[r-1][c] : '1';
        char left = c-1>=0 ? board[r][c-1] : '1';
        char right = c+1 < board[0].length ? board[r][c+1] : '1';
        char down = r+1 < board.length ? board[r+1][c] : '1';
        if(top == word.charAt(index+1) && !front.equals("top")){
            if(find(r-1,c,board,word,index+1,"down")){
                return true;
            }
        }
        if(left == word.charAt(index+1) && !front.equals("left")){
            if(find(r,c-1,board,word,index+1,"right")){
                return true;
            }
        }
        if(right == word.charAt(index+1) && !front.equals("right")){
            if(find(r,c+1,board,word,index+1,"left")){
                return true;
            }
        }
        if(down == word.charAt(index+1) && !front.equals("down")){
            if(find(r+1,c,board,word,index+1,"top")){
                return true;
            }
        }
        return false;
    }
}