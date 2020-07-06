package LeetCode;

public class 长度最小的子数组_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            int cur = nums[i];
            int count = 1;
            if(nums[i] >= s){
                ans = 1;
            }
            for(int j = i + 1;j<nums.length;j++){
                cur += nums[j];
                count ++;
                if(cur >= s){
                    ans = Math.min(ans, count);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
