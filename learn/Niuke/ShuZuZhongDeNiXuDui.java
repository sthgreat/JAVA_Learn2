package Niuke;

/***
 * 使用归并排序的方法进行排序，
 * 在排序过程中，左右半边数组都已经排序完成，在归并过程中，
 * 即可统计数组的逆序对。
 */
public class ShuZuZhongDeNiXuDui {
    private int count;
    public int InversePairs(int [] array) {
        int[] a = sort(array, 0, array.length - 1);
        return count;
    }

    public int[] sort(int[] arr, int low, int high){
        int mid = (low + high) >>> 1;
        if(low < high){
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr,low,mid,high);
        }
        return arr;
    }

    public void merge(int[] arr, int low, int mid, int high){
        int[] c = new int[high - low + 1];
        int pin = 0; //记录c数组位置的指针
        int i = low;
        int j = mid + 1;
        while(i <= mid && j <=high){
            if(arr[i] > arr[j]){
                c[pin++] = arr[j++];
                this.count = (this.count + mid - i + 1)%1000000007;
            }else{
                c[pin++] = arr[i++];
            }
        }
        while(i <= mid){
            c[pin++] = arr[i++];
        }
        while(j <= high){
            c[pin++] = arr[j++];
        }
        for(int n = 0;n<c.length;n++){
            arr[n+low] = c[n];
        }
    }
}
