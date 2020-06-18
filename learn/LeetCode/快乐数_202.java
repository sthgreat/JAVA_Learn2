package LeetCode;

/***
 * 使用hashset记录循环
 *
 */
public class 快乐数_202 {
    public boolean isHappy(int n) {
        int count = 0;
        while(count < 100){
            if(n == 1){
                return true;
            }
            String num = String.valueOf(n);
            int curNum = 0;
            for(int i = 0;i<num.length();i++){
                int curN = num.charAt(i) - '0';
                curNum += curN * curN;
            }
            n = curNum;
            count++;
        }

        return false;
    }
}
