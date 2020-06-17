package LeetCode;

/***
 * 位运算
 */
public class 颠倒二进制位_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int size = 31; n!=0;size--){
            ans += (n & 1) << size;
            n = n>>>1;
        }
        return ans;
    }
}
