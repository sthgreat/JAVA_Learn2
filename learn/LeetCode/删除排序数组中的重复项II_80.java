package LeetCode;

/***
 *
 * 单指针做法，遍历数组，用count变量记录当前数的出现次数，大于2时进行删除操作。
 * 注意：count的更新
 */
public class 删除排序数组中的重复项II_80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }

        int count = 1;
        int length = nums.length;

        for(int i = 1;i<length;i++){
            if(nums[i] == nums[i-1]){
                count++;
                if(count > 2){
                    while(i<length && nums[i] == nums[i-1]){//按顺序删除相同的
                        delete(i, nums, length);
                        length --;
                    }
                    count = 1;
                }
            }else{
                count = 1;
            }
        }

        return length;
    }

    public void delete(int index, int[] nums,int length){
        for(int i = index; i<length;i++){
            if(i+1<length){
                nums[i] = nums[i+1];
            }
        }
    }
}