package Base;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,5};
        int[] b = Arrays.copyOfRange(a, 0,1);
        for (int value : b) {
            System.out.print(value + " ");
        }
    }
}
