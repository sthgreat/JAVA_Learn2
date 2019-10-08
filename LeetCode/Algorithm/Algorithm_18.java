package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm_18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            int start = 0;
            while(start<nums.length){
                if(start - 1 >= 0 && nums[start] == nums[start-1]){
                    start++;
                    continue;
                }
                int start_2 = start + 1;
                while(start_2<nums.length){
                    if(start_2 - 1 >= start+1 && nums[start_2] == nums[start_2-1]){
                        start_2++;
                        continue;
                    }
                    int head = start_2 + 1;
                    int tail = nums.length - 1;
                    while(head<tail){
                        if(nums[start]+nums[start_2]+nums[head]+nums[tail] == target){
                            List<Integer> l = new ArrayList<Integer>();
                            l.add(nums[start]);
                            l.add(nums[start_2]);
                            l.add(nums[head]);
                            l.add(nums[tail]);
                            if(!result.contains(l)){
                                result.add(l);
                            }
                            head++;
                        }else if(nums[start]+nums[start_2]+nums[head]+nums[tail] < target){
                            head++;
                        }else{
                            tail--;
                        }
                    }
                    start_2++;
                }

                start++;
            }
            return result;
        }
    }
}
