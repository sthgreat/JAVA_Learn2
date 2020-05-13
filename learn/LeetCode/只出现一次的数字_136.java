package LeetCode;

/***
 * 使用异或来解决问题
 * 一个数字与自身异或是0，一个数字与0异或是它本身
 */
public class 只出现一次的数字_136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            ans ^= nums[i];
        }
        return ans;
    }
}
