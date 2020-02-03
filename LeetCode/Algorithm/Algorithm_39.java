import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> r = new ArrayList<Integer>();
        result = new ArrayList<>();
        traceback(target,0,r,candidates);
        return result;
    }

    public void traceback(int target, int sum, List<Integer> r,int[] candidates){
        if(sum>target){
            return;
        }
        if(sum == target){
            List<Integer> k = new ArrayList<>();
            k.addAll(r);
            Integer[] arry = (Integer[]) k.toArray(new Integer[k.size()]);
            Arrays.sort(arry);
            k = Arrays.asList(arry);
            if(!result.contains(k)){
                result.add(k);
                return;
            }
        }
        for(int i =0;i<candidates.length;i++){
            r.add(candidates[i]);
            traceback(target,sum+candidates[i],r,candidates);
            r.remove(r.size()-1);
        }
    }
}
