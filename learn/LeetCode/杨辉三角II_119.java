package LeetCode;

import java.util.LinkedList;
import java.util.List;

/***
 * 用动态规划来求解
 */
public class 杨辉三角II_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new LinkedList<>();
        int[][] record = new int[rowIndex + 1][rowIndex + 1];
        record[0][0] = 1;
        for(int i = 1;i<=rowIndex;i++){
            for(int j = 0; j <= i;j++){
                if(j == 0 || j == i){
                    record[i][j] = 1;
                }else{
                    record[i][j] = record[i-1][j-1]+record[i-1][j];
                }
            }
        }

        for(int i = 0;i<=rowIndex;i++){
            ans.add(record[rowIndex][i]);
        }
        return ans;
    }
}