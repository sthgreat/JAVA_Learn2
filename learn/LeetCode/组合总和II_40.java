package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和II_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        func(ans, candidates, target, 0, 0, new LinkedList<>());
        return ans;
    }

    public void func(List<List<Integer>> ans, int[] candidates,int target, int start,
                     int cur, LinkedList<Integer> arr){
        if(cur == target){
            List<Integer> temp = new LinkedList<>(arr);
            ans.add(temp);
            return;
        }else if(cur > target){
            return;
        }

        for(int i = start;i<candidates.length;i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            arr.add(candidates[i]);
            func(ans, candidates, target, i + 1, cur + candidates[i], arr);
            arr.removeLast();
        }

    }
}
