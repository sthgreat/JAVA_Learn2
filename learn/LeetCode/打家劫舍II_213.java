package LeetCode;

/***
 * 首尾不相连
 * 通过对0， length-2 和 1，length-1两个数列进行统计，将大问题化成小问题进行解决
 */
public class 打家劫舍II_213 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        int a = find(nums, 0, nums.length - 2);
        int b = find(nums, 1, nums.length - 1);
        return Math.max(a, b);
    }

    public int find(int[] nums, int start, int end){
        int[] record = new int[nums.length];
        int ans = nums[start];
        record[start] = nums[start];
        if(end - start + 1 >= 2){
            record[start + 1] = nums[start + 1];
            ans = Math.max(nums[start], nums[start+1]);
        }else{
            return nums[start]; //返回长度为1的值
        }

        for(int i = start + 2;i<=end;i++){
            if(i - start < 3){
                record[i] = Math.max(record[i - 2] + nums[i], nums[i-1]);
            }else{
                record[i] = Math.max(record[i-2] + nums[i], record[i-3] + nums[i]);
            }
        }
        return Math.max(record[end], record[end-1]);
    }
}
