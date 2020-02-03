class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "" + 1;
        }else{
            return generateStr(countAndSay(n-1));
        }
    }

    public String generateStr(String str){ //输入上一轮字符串，得到本轮字符串
        int strlen = str.length();
        StringBuilder sb = new StringBuilder();
        char current_num = str.charAt(0); //记录当前数字
        int count = 1; //记录当前数字已经重复的个数
        for(int i = 0;i<strlen;i++){
            if(i+1<strlen && (str.charAt(i)==(str.charAt(i+1)))){ //下一位数字重复出现
                count++;
            }else if(i+1<strlen && (str.charAt(i)!=(str.charAt(i+1)))){ //下一位数字不相同
                sb.append(""+count+current_num);
                current_num = str.charAt(i+1); //恢复初始
                count = 1;
            }else{ //末尾
                sb.append(""+count+current_num);
                break;
            }
        }
        return sb+"";
    }
}