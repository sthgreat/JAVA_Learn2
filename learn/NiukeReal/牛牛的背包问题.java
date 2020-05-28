package NiukeReal;

import java.util.Scanner;

public class 牛牛的背包问题 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int c = sc.nextInt();
        int[] food = new int[count];
        for(int i = 0;i<count;i++){
            food[i] = sc.nextInt();
        }
        long sum = 0;
        for(int i = 0;i<count;i++){
            sum += food[i];
        }
        if(sum <= c){
            System.out.println((long)Math.pow(2,food.length));
            return;
        }
        System.out.println(solution(food, food.length - 1,c));
    }

    public static int solution(int[] food, int curPos,int cap){
        if(curPos == 0){
            if(food[0] <= cap){
                return 2;
            }else{
                return 1;
            }
        }
        if(cap == 0){
            return 1;
        }

        if(cap - food[curPos] >= 0){
            return solution(food, curPos - 1, cap - food[curPos]) + solution(food, curPos - 1, cap);
        }else{
            return solution(food, curPos - 1, cap);
        }
    }
}
