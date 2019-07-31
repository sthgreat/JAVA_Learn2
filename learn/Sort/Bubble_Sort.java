package Sort;

public class Bubble_Sort {
    private void sort(int[] arr) {//原始冒泡排序
        int temp;
        for (int i=0; i<arr.length;i++){
            for(int j =0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] =arr[i];
                    arr[i] =temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 7, 5, 9, 12, 3, 8};

    }
}
