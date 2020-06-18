package LeetCode;

/***
 * 位运算，与操作
 * 有点意思
 */
public class 数字范围按位与_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int left = 0;
        while(m < n){
            m >>= 1;
            n >>= 1;
            left++;
        }
        return m << left;
    }
}