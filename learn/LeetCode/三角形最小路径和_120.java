package LeetCode;

import java.util.List;

/***
 * 动态规划
 */
public class 三角形最小路径和_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] record = new int[triangle.size()][triangle.size()];
        record[0][0] = triangle.get(0).get(0);
        for(int i = 1;i<triangle.size();i++){
            List<Integer> cur = triangle.get(i);
            for(int j = 0;j<cur.size();j++){
                if(j == 0){
                    record[i][j] = record[i-1][j] + cur.get(j);
                }else if(j == cur.size() - 1){
                    record[i][j] = record[i-1][j - 1] + cur.get(j);
                }else{
                    int result1 = record[i-1][j-1] + cur.get(j);
                    int result2 = record[i-1][j] + cur.get(j);
                    record[i][j] = Math.min(result1, result2);
                }
            }
        }
        int min = record[triangle.size() - 1][0];
        for(int i = 1;i<triangle.size();i++){
            min = Math.min(min, record[triangle.size() - 1][i]);
        }
        return min;
    }
}
