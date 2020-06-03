package LeetCode;

/***
 * 动态规划问题
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] record = new int[nums.length];
        record[0] = nums[0];
        record[1] = nums[1];
        for(int i = 2; i<nums.length;i++){
            if(i == 2){
                record[i] = record[i -2] + nums[i];
            }else{
                int max = record[i - 3];
                max = Math.max(max, record[i - 2]);
                record[i] = max + nums[i];
            }
        }
        return record[nums.length - 1] > record[nums.length - 2] ? record[nums.length - 1] : record[nums.length - 2];
    }
}
