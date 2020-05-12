package LeetCode;

import java.util.LinkedList;

public class 被围绕的区域_130 {
    public void solve(char[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(isEdge(i,j,board.length,board[i].length) && board[i][j] == 'O'){
                    bfs(i, j, board);
                }
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    boolean isEdge(int i, int j, int maxI, int maxJ){
        return i == 0 || i == maxI - 1 || j == 0 || j == maxJ - 1;
    }

    void bfs(int i, int j, char[][] board){
        LinkedList<Pos> list = new LinkedList<>();
        board[i][j] = '#';
        list.add(new Pos(i, j));
        while(!list.isEmpty()){
            Pos p = list.removeFirst();
            int x = p.x;
            int y = p.y;
            if(x - 1 >= 0 && board[x - 1][y] == 'O'){ //向上
                list.add(new Pos(x - 1, y));
                board[x - 1][y] = '#';
            }
            if(x + 1 < board.length && board[x + 1][y] == 'O'){//向下
                list.add(new Pos(x + 1, y));
                board[x+1][y] = '#';
            }
            if(y - 1 >= 0 && board[x][y-1] == 'O'){//向左
                list.add(new Pos(x, y - 1));
                board[x][y-1] = '#';
            }
            if(y+1 < board[x].length && board[x][y+1]=='O'){//向右
                list.add(new Pos(x, y + 1));
                board[x][y+1] = '#';
            }
        }
    }

    public static class Pos{
        public int x;
        public int y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
