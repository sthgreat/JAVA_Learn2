package SwordToOffer;

public class 左旋转字符串_58 {
    public String reverseLeftWords(String s, int n) {
        return(s.substring(n, s.length()) + s.substring(0, n));
    }
}
