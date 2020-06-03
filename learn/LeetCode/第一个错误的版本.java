package LeetCode;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/***
 * 利用二分法求解
 */
public class 第一个错误的版本 {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int i){
        return true;
    }
}
