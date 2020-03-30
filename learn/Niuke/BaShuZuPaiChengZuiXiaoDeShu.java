package Niuke;

import java.util.ArrayList;
import java.util.LinkedList;

public class BaShuZuPaiChengZuiXiaoDeShu {
    private boolean flag = true;
    private Long min;
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0){
            return "";
        }

        LinkedList<Long> numQueue = new LinkedList<>();
        ArrayList<Long> numArray = new ArrayList<>();
        //Long min = 1L;
        for(int i = 0; i<numbers.length; i++){
            Long k = Long.valueOf(numbers[i]);
            numQueue.add(k);
        }

        l(numQueue, numArray);
        return String.valueOf(min);
    }

    void l(LinkedList<Long> numQueue, ArrayList<Long> numArray){
        if(numQueue.size() == 0){
            StringBuilder sb = new StringBuilder();
            for(int n = 0; n<numArray.size();n++){
                sb.append(String.valueOf(numArray.get(n)));
            }
            Long nnn = Long.valueOf(sb.toString());
            if(flag == true){
                min = nnn;
                flag = false;
                return;
            }
            if(min > nnn){
                min = nnn;
            }
            return;
        }

        for(int i = 0; i < numQueue.size(); i++){
            Long num = numQueue.pollFirst();
            numArray.add(num);
            l(numQueue, numArray);
            numArray.remove(numArray.size() - 1);
            numQueue.add(num);
        }


    }
}
