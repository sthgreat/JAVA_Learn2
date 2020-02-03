package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class timu {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.print(s.divide(-2147483648,-1));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        List A = new ArrayList();
        long dividend_long = (long) dividend;
        long divisor_long = (long) divisor;
        int flag = 1; //记录符号
        if(dividend_long < 0){
            dividend_long = -dividend_long;
            flag = -flag;
        }
        if(divisor_long < 0){
            divisor_long = -divisor_long;
            flag = -flag;
        }

        long ans = doDivide(dividend_long, divisor_long);
        long m = 2147483648L;
        if(ans == m ){
            return Integer.MAX_VALUE;
        }else{
            if(flag > 0){
                return (int)ans;
            }else{
                return -(int)ans;
            }
        }
    }

    public long doDivide(long dividend,long divisor){
        long count = 0;
        long currentDivisor = divisor;

        if(dividend < divisor){
            return 0;
        }

        while(dividend >= currentDivisor){
            count+=1;
            currentDivisor += divisor;
        }
        dividend = dividend - currentDivisor;

        count = count + doDivide(dividend, divisor);

        return count;
    }
}