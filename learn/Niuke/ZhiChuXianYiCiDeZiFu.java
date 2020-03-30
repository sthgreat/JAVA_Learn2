package Niuke;

/***
 * 创建一个数组，利用hash值进行计数，再次遍历字符串和数组返回第一个值为1的
 */
public class ZhiChuXianYiCiDeZiFu {
    public int FirstNotRepeatingChar(String str) {
        int[] words = new int[58];
        for(int i = 0;i<str.length();i++){
            words[((int)str.charAt(i))-65] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }
}
