package NiukeReal;

import java.util.*;

public class Shoppe的办公室 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int BossCount = sc.nextInt();
        long[][] matrix = new long[Math.max(x,y) + 1][Math.max(x,y) + 1];
        for(int i = 0;i<BossCount;i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            matrix[x1][y1] = -1;
        }
        for(int i = 0;i <= x;i++){
            for(int j = 0;j<=y;j++){
                if(i == 0 && j == 0){
                    matrix[i][j] = 1;
                    continue;
                }
                if(i == 0 && matrix[i][j - 1] != -1 && matrix[i][j] != -1){
                    matrix[i][j] = matrix[i][j - 1];
                }else if(j == 0 && matrix[i - 1][j] != -1 && matrix[i][j] != -1){
                    matrix[i][j] = matrix[i - 1][j];
                }else{
                    if(matrix[i][j] != -1 && matrix[i -1][j] != -1){
                        matrix[i][j] += matrix[i -1][j];
                    }
                    if(matrix[i][j] != -1 && matrix[i][j - 1] != -1){
                        matrix[i][j] += matrix[i][j - 1];
                    }
                }
            }
        }
        System.out.println(matrix[x][y]);
    }
}
