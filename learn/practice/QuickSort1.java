package practice;

public class QuickSort1 {

    public static void main(String[] args){
        int[] a = new int[]{1,1,0,1,1};
        QuickSort1 q= new QuickSort1();
        int[] sort = q.sort(a, 0, a.length - 1);
        for(int num : sort){
            System.out.print(num+",");
        }
    }

    public int[] sort(int[] arr, int start, int end){
        int temp = arr[start];
        int i = start;
        int j = end;
        while(i < j){
            while(arr[j] > temp && i<j){
                j --;
            }
            while(arr[i] < temp && i<j){//很巧妙地避开了第一个的问题
                i ++;
            }
            if(arr[i] == arr[j] && i < j){
                i++;
            }else{
                swap(arr, i, j);
            }
        }
        if(i - 1 > start){
            arr = sort(arr, start, i - 1);
        }
        if(j + 1 < end){
            arr = sort(arr, j + 1, end);
        }

        return arr;
    }

    private void swap(int[] arr, int p1, int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
