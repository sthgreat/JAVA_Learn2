package Algorithm;

public class Algorithm_12 {
    /**
     * 采用贪心算法
     */
    class Solution {
        public String intToRoman(int num) {
            int[] n = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
            String[] s = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
            int pin = n.length-1;
            int temp = 0;
            String result = "";
            while(temp!=num){
                if(temp+n[pin]<=num){
                    temp+=n[pin];
                    result = result.concat(s[pin]);
                }else{
                    if(pin >= 1){
                        pin = pin - 1;
                    }
                }
            }
            return result;
        }
    }
}
