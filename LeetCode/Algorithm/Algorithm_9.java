package Algorithm;

public class Algorithm_9 {
    class Solution {
        public boolean isPalindrome(int x) {
            if(x<0){
                return false;
            }
            if(x==0){
                return true;
            }
            String s = String.valueOf(x);
            if(s.length() == 1){
                return true;
            }
            int i = 0,j=s.length()-1;
            while(i!=j&&i<j){
                if(s.charAt(i++)!=s.charAt(j--)){
                    return false;
                }
            }
            return true;
        }
    }
}
