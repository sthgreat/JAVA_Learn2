package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args){
        System.out.println(func(1));
    }

    public static int func(int cur){
        if(cur == 5){
            return 8;
        }
        int ans = (5 * func(cur + 1)) / 4 + 1;
        System.out.println(ans);
        return ans;
    }
}