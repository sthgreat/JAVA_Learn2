package NiukeReal;

import java.util.*;

/***
 * 穷举...
 */
public class 表达式求值 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = a*b*c;
        if(a*b+c > max){
            max = a*b + c;
        }
        if(a + b*c > max){
            max = a*b + c;
        }
        if((a+b)*c > max){
            max = (a+b)*c;
        }
        if(a*(b+c)>max){
            max = a*(b+c);
        }
        if(a+b+c > max){
            max = a+b+c;
        }
        System.out.println(max);
    }
}
