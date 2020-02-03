class Solution {
    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(lengthA > 0 && lengthB > 0){
            int ans = (a.charAt(lengthA - 1) - '0') +  (b.charAt(lengthB - 1) - '0') + carry;
            if(ans == 0){
                sb.append('0');
                carry = 0;
            }else if(ans == 1){
                sb.append('1');
                carry = 0;
            }else if(ans == 2){
                sb.append('0');
                carry = 1;
            }else{
                sb.append('1');
                carry = 1;
            }
            lengthA -= 1;
            lengthB -= 1;
        }

        if(lengthA == 0){
            for(int i = lengthB - 1;i>=0;i--){
                int ans2 = carry + b.charAt(i) - '0';
                if(ans2 == 0){
                    sb.append('0');
                    carry = 0;
                }else if(ans2 == 1){
                    sb.append('1');
                    carry = 0;
                }else if(ans2 == 2){
                    sb.append('0');
                    carry = 1;
                }
            }
        }else{
            for(int i = lengthA - 1;i>=0;i--){
                int ans2 = carry + a.charAt(i) - '0';
                if(ans2 == 0){
                    sb.append('0');
                    carry = 0;
                }else if(ans2 == 1){
                    sb.append('1');
                    carry = 0;
                }else if(ans2 == 2){
                    sb.append('0');
                    carry = 1;
                }
            }
        }
        if(carry == 1){
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}