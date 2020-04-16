package LeetCode;

import java.util.ArrayList;
import java.util.List;

/***
 * 先加入，后加入的需要先跟之前的已有的相累加后加入结果集
 */
public class 子集_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        traceback(0,result,nums,new ArrayList<Integer>());

        return result;
    }

    public void traceback(int i,List<List<Integer>> result, int[] nums, ArrayList<Integer> arr){
        result.add(new ArrayList<>(arr));
        for(int j = i;j<nums.length;j++){
            arr.add(nums[j]);
            traceback(j+1,result,nums,arr);
            arr.remove(arr.size() - 1);
        }
    }
}
