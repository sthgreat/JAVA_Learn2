package Niuke;

/***
 * 主要是要注意是循环旋转，需要对n做一定的处理
 */
public class 左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0 || n%len == 0){
            return str;
        }
        n = n % len;
        StringBuilder sb = new StringBuilder();
        for(int i = n;i<str.length();i++){
            sb.append(str.charAt(i));
        }
        for(int i = 0;i<n;i++){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}