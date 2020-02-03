class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while(left < right){
            long mid = left + (right - left + 1) / 2;
            if(mid * mid > x){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return (int) left;
    }
}