package NiukeReal;

import java.util.*;
import java.io.*;

/***
 * 难点在于如何将数据关联起来
 * 这里使用一个hashmap将所有难度-报酬记录下来
 * 员工能力在hashmap中初始化为能力-0
 * 更新hashmap，使hashmap变更为难度-最高报酬（排序难度数组，初始化报酬为0，根据排序后的数组更新hashmap值）
 * 高能力肯定能获得低难度的最大报酬
 * 最后以员工能力为key，访问hashmap得到最高报酬
 */
public class 牛牛找工作 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int jobNum = sc.nextInt();
        int peopleNum = sc.nextInt();
        int[] friendAbillity = new int[peopleNum];
        int[] wholeDifficulty = new int[jobNum + peopleNum];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i<jobNum;i++){
            int difficulty = sc.nextInt();
            int pay = sc.nextInt();
            wholeDifficulty[i] = difficulty;
            if(map.get(difficulty) != null){
                int max = map.get(difficulty) > pay ? map.get(difficulty) : pay;
                map.put(difficulty, max);
            }else{
                map.put(difficulty, pay);
            }
        }

        for(int i = 0;i<peopleNum;i++){
            int abillity = sc.nextInt();
            if(map.get(abillity) == null){
                map.put(abillity, 0);
            }
            wholeDifficulty[jobNum + i] = abillity;
            friendAbillity[i] = abillity;
        }
        Arrays.sort(wholeDifficulty);
        int payMax = 0;
        for(int i = 0;i<jobNum + peopleNum;i++){
            payMax = map.get(wholeDifficulty[i]) > payMax ? map.get(wholeDifficulty[i]) : payMax;
            map.put(wholeDifficulty[i], payMax);
        }

        for(int i = 0; i<peopleNum; i++){
            System.out.println(map.get(friendAbillity[i]));
        }
    }
}
