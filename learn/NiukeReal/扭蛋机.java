package NiukeReal;

import java.util.*;

/***
 * 跳格子，按照奇偶进行划分
 */
public class 扭蛋机 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(target!=0){
            if(target%2==0){
                target = (target - 2) / 2;
                sb.insert(0, "3");
            }else{
                target = (target - 1) / 2;
                sb.insert(0, "2");
            }
        }
        System.out.println(sb.toString());
    }
}
