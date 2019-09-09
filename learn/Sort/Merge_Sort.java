package Sort;

public class Merge_Sort {
    public int[] sort(int[] a, int low, int high){
        int mid = (high + low)/2;
        if (low<high){
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low , mid, high);
        }
        return a;
    }

    public void merge(int[] a, int low, int mid, int high){
        int[] c = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int count = 0;
        while (i<=mid && j<=high){
            if(a[i]<a[j]){
                c[count++] = a[i++];
            }else {
                c[count++] = a[j++];
            }
        }
        while (i<=mid){
            c[count++] = a[i++];
        }
        while (j<=high){
            c[count++] = a[j++];
        }

        for(int len = 0;len<c.length;len++){
            a[low + len] = c[len];
        }
    }

    public static void main(String[] args){
        int[] li = new int[]{2,7,1,4,9,5,3,1};
        Merge_Sort merge_sort = new Merge_Sort();
        merge_sort.sort(li, 0, 7);
        for(int num : li){
            System.out.print(num+",");
        }
    }
}
