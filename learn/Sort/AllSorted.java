package Sort;

public class AllSorted {
    /***
     * 全排列
     */
    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4};
        AllSorted sorted = new AllSorted();
        sorted.sort(a, 0, a.length);
    }

    public void sort(int[] arr, int start, int end){
        if(start == end){
            for (int i : arr) {
                System.out.print(i + ",");
            }
            System.out.println(" ");
        }
        for(int i = start; i<end; i++){
            swap(arr, start, i);
            sort(arr, start + 1, end);
            swap(arr, start, i);
        }
    }

    private void swap(int[] arr, int p1, int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
