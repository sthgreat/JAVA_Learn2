package Base;

import java.util.ArrayList;
public class Test {
    public static void main(String[] args){
        Test t = new Test();
        int[] a = new int[]{1,2,4,7,11,16};

        ArrayList<Integer> integers = t.FindNumbersWithSum(a, 17);
        System.out.println(integers.toString());
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int target = sum / 2;
        int start = 0;
        int end = array.length - 1;
        if(array.length < 2){
            return null;
        }

        while(start < end){
            int mid = (start + end) >>> 1;
            if(array[mid] < target){
                start = mid + 1;
            }else if(array[mid] == target){
                start = mid;
                break;
            }else{
                end = mid;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int head = start;
        int tail = start + 1;
        for(int i = start; i>= 0; i--){
            if(array[i] + array[start + 1] > sum){
                continue;
            }
            for(int j = start + 1;j<array.length;j++){
                if(array[i] + array[j] > sum){
                    break;
                }
                if(array[i] + array[j] == sum){
                    if(i < head){
                        head = i;
                        tail = j;
                    }
                }
            }
        }
        result.add(array[head]);
        result.add(array[tail]);
        return result;
    }
}