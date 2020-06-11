package LeetCode;

/***
 * 使用二分查找的思想，观察节点所在区间为上升区间还是下降区间为判断左右边界收拢的条件
 * 注意：左>当前 && 右>当前 的情况
 */
public class 寻找峰值_162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int left = 1;
        int right = nums.length - 2;
        if(nums[0] > nums[1]){
            return 0;
        }else if(nums[nums.length - 1] > nums[nums.length - 2]){
            return nums.length - 1;
        }
        while(left < right){
            int mid = (left + right) >>> 1;
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(nums[mid - 1] >= nums[mid] && nums[mid] >= nums[mid+1]){ // 递减
                right = mid;
            }else if(nums[mid - 1] <= nums[mid] && nums[mid] <= nums[mid + 1]){  //递增
                left = mid + 1;
            }else{
                left += 1;
            }
        }

        return left;
    }
}
