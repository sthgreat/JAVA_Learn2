package LeetCode;

public class 加油站_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gasLeft = new int[gas.length];//存储从i 到 i+1 加油站后剩余的油量
        for(int i = 0;i<gas.length;i++){
            gasLeft[i] = gas[i] - cost[i];
        }

        for(int i = 0;i<gasLeft.length;i++){
            if(gasLeft[i]>=0){
                int count = 0;
                int cur = i;
                for(int j = 0;j<gasLeft.length;j++){
                    count += gasLeft[cur];
                    if(count < 0){//油不够移动到下一个加油站
                        break;
                    }
                    if(cur + 1 == gasLeft.length){
                        cur = 0;
                    }else{
                        cur += 1;
                    }
                }
                if(count >= 0){
                    return i;
                }
            }
        }

        return -1;
    }
}
