package Sort;

public class test {
    private static int[] Quick_Sort(int[] array, int start, int end) {
        int num = array[start];
        int i = start;
        int j = end;
        while(i<j){
            while (array[i] < num && i<j){
                i++;
            }
            while (array[j] > num && i<j){
                j--;
            }if(array[i] == array[j]){
                i++;
            }
            else {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if(i-1 > start) array = Quick_Sort(array, start, i-1);
            if(j+1 < end)array = Quick_Sort(array, j+1,end);
        }
        return array;
    }

    public static int[] Merge_Sort(int[] a, int low, int high){
        int mid = (low + high)/2;
        if(low<high){
            Merge_Sort(a, low, mid);
            Merge_Sort(a, mid +1, high);
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[]a, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int count = 0;
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[count++] = a[i++];
            }else {
                temp[count++] = a[j++];
            }
        }
        while (j<=high){
            temp[count++] = a[j++];
        }

        while (i<=mid){
            temp[count++] = a[i++];
        }

        for(int num = 0;num<temp.length;num++){
            a[low + num] = temp[num];
        }
    }

    public static void main(String[] args) {
        int[] li = new int[]{2, 7, 1, 4, 9, 5, 3, 1};
        int[] after = test.Quick_Sort(li, 0, li.length - 1);
        for (int num : after) {
            System.out.print(num + ",");
        }
    }
}
