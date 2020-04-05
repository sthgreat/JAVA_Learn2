package practice;

public class MergeSort1 {
    public static void main(String[] args){
        int[] a = new int[]{1,1,0,0,1};
        MergeSort1.sort(a, 0, a.length - 1);
        for (int value : a) {
            System.out.println(value);
        }
    }

    public static int[] sort(int[] arr, int start, int end){
        if(start == end){
            return arr;
        }
        int mid = (start + end) >>> 1;
        arr = sort(arr, start, mid);
        arr = sort(arr, mid + 1, end);
        return merge(arr, start, mid, end);
    }

    private static int[] merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int count = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[count ++] = arr[i ++];
            }else{
                temp[count ++] = arr[j ++];
            }
        }
        if(i <= mid){
            for(int n = i ;n<=mid;n++){
                temp[count++] = arr[i++];
            }
        }
        if(j <= end){
            for(int n = j ;n<=end;n++){
                temp[count++] = arr[j++];
            }
        }
        //把temp内容复制到arr中
        for(int n = start; n<=end;n++){
            arr[n] = temp[n-start];
        }
        return arr;
    }
}
