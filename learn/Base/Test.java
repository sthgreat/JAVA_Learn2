package Base;

public class Test {
    public static void main(String[] args){
        Test t = new Test();
        System.out.println(t.LeftRotateString("abcXYZdef", 0));
    }

    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(n%len == 0){
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