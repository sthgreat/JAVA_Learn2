package NiukeReal;

import java.util.*;

/***
 * AC 0.8，超时
 */
public class 编程题2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int num = sc.nextInt();
        int lastNum = sc.nextInt() - 1;
        int[] rooms = new int[num];
        for(int i = 0;i<num;i++){
            int temp = sc.nextInt();
            min = Math.min(min, temp);
            rooms[i] = temp;
        }
        int cumulate = 0;
        while(rooms[lastNum] != 0){
            rooms[lastNum] -= 1;
            cumulate++;

            if(lastNum == 0){
                lastNum = rooms.length - 1;
            }else{
                lastNum -= 1;
            }
        }
        rooms[lastNum] = cumulate;

        for(int i = 0;i<rooms.length;i++){
            if(i != rooms.length - 1){
                System.out.print(rooms[i] + " ");
            }else{
                System.out.print(rooms[i]);
            }
        }
    }
}
