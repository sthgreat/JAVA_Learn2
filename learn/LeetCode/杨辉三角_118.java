package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class 杨辉三角_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        if(numRows == 0){
            return ans;
        }
        int[] pre = new int[]{1};
        LinkedList<Integer> a = new LinkedList<>();
        a.add(1);
        ans.add(a);
        for(int i = 2;i<=numRows;i++){
            int[] record = new int[i];
            record[0] = 1;
            record[record.length - 1] = 1;
            for(int j = 1;j<=record.length - 2;j++){
                record[j] = pre[j-1] + pre[j];
            }
            LinkedList<Integer> list = new LinkedList<>();
            for(int num : record){
                list.add(num);
            }
            ans.add(list);
            pre = record;
        }
        return ans;
    }
}
