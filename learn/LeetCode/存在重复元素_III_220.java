package LeetCode;

public class 存在重复元素_III_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean flag = false;
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1;j<= Math.min(i + k, nums.length - 1);j++){
                long n_i = nums[i];
                long n_j = nums[j];
                if(Math.abs(n_i - n_j) <= t){
                    return true;
                }
            }
        }
        return flag;
    }
}
