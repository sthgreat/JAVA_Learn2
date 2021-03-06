package Sort;

public class Quick_Sort {
    public int[] q_sort(int[] array, int start, int last) {
        int i = start;
        int j = last;
        int num = array[start];
        while (i < j) {
            while (array[j] > num && i < j) {
                j--;
            }
            while (array[i] < num && i < j) {
                i++;
            }if(array[i] == array[j] && i<j){
                i++;
            }else {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        if (i-1>start) array=q_sort(array,start,i-1);
        if (j+1<last) array=q_sort(array,j+1,last);
        return array;
    }

    public static void main(String[] args) {
        int[] li = new int[]{1,1,2,2,1,1,2,1};
        Quick_Sort quick_sort = new Quick_Sort();
        int[] after = quick_sort.q_sort(li,0,li.length-1);
        for(int num : after){
            System.out.print(num+",");
        }
    }
}
