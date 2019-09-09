package Sort;

public class Selection_Sort {
    public void sort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 7, 5, 9, 12, 3, 8};
        Selection_Sort selection_sort = new Selection_Sort();
        SortUtils sortUtils = new SortUtils();
        selection_sort.sort(a);
        sortUtils.show(a);
    }
}