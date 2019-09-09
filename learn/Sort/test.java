package Sort;

public class test {
    private static int[] Quick_Sort(int[] array, int start, int end) {
        int num = array[start];
        int i = start;
        int j = end;
        while(i<j){
            while (array[i]<num && i<j){
                i++;
            }while (array[j]>num && i<j){
                j--;
            }if(array[i] == array[j] && i<j){
                i++;
            }else {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            if(i-1>start)Quick_Sort(array, start, i-1);
            if(j+1<end) Quick_Sort(array, j+1,end);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] li = new int[]{2, 7, 1, 4, 9, 5, 3, 1};
        int[] after = Quick_Sort(li, 0, li.length - 1);
        for (int num : after) {
            System.out.print(num + ",");
        }
    }
}
