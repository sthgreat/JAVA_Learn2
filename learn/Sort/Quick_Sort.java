package Sort;

public class Quick_Sort {
    public static int[] q_sort(int[] array, int start, int last) {
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
            if (i-1>start) array=q_sort(array,start,i-1);
            if (j+1<last) array=q_sort(array,j+1,last);
            return (array);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] li = new int[]{2,7,1,4,9,5,3,1};
        int[] after = q_sort(li,0,li.length);
        for(int num : after){
            System.out.print(num+",");
        }
    }
}
