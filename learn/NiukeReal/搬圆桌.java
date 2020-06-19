package NiukeReal;

import java.util.*;
public class 搬圆桌 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            long r = Integer.parseInt(ss[0]);
            long x = Integer.parseInt(ss[1]);
            long y = Integer.parseInt(ss[2]);
            long x1 = Integer.parseInt(ss[3]);
            long y1 = Integer.parseInt(ss[4]);
            double len = Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
            int ans = 0;
            while(len >= r){
                ans ++;
                len = len - 2*r;
            }
            if(len == 0){
                System.out.println(ans);
            }else{
                System.out.println(ans + 2);
            }
        }
    }
}
