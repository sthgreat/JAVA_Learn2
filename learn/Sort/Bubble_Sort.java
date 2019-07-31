package Sort;

public class Bubble_Sort {
    private void sort(int[] arr) {//原始冒泡排序
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 7, 5, 9, 12, 3, 8};
        Bubble_Sort bubble_sort = new Bubble_Sort();
        SortUtils sortUtils = new SortUtils();
        bubble_sort.sort(a);
        sortUtils.show(a);
    }
}
