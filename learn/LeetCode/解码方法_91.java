package LeetCode;

/***
 * 动态规划
 */
public class 解码方法_91 {
    public int numDecodings(String s) {
        int[] nums = new int[s.length() + 1];
        for(int i = 0;i<s.length();i++){
            nums[i + 1] = s.charAt(i) - '0';
        }
        int[] record = new int[s.length() + 1];
        record[0] = 1;
        for(int i = 1;i<=s.length();i++){
            if(nums[i] == 0){
                if(i == 1){
                    return 0;
                }else{
                    int num = nums[i - 1] * 10 + nums[i];
                    if(num>26 || num == 0){
                        return 0;
                    }else{
                        record[i] = record[i-2];
                    }
                }
            }else{
                if(i == 1){
                    record[i] = 1;
                    continue;
                }
                int num = nums[i - 1] * 10 + nums[i];
                if(num < 10){
                    record[i] = record[i-1];
                }else if(num > 26){
                    record[i] = record[i-1];
                }else{
                    record[i] = record[i - 1] + record[i - 2];
                }
            }
        }
        return record[s.length()];
    }
}
