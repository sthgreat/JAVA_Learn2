package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class 组合总和III_216 {
    private static List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] num = new int[]{0,1,2,3,4,5,6,7,8,9};
        ans = new LinkedList<>();
        find(k, n, new LinkedList<>(), 0, num, 1, 0);
        return ans;
    }

    public void find(int k, int n, LinkedList<Integer> record, int cur, int[] num, int start, int curV){
        if(cur == k && curV == n){
            LinkedList<Integer> temp = new LinkedList<>(record);
            ans.add(temp);
            return;
        }else if(curV > n || cur > k){
            return;
        }


        for(int i = start;i<= 9;i++){
            record.add(num[i]);
            find(k,n,record,cur + 1,num,i+1,curV + num[i]);
            record.removeLast();
        }
    }
}
