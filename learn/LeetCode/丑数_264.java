package LeetCode;

public class 丑数_264 {
    public int nthUglyNumber(int n) {
        if(n == 1){
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i = 1;i<arr.length;i++){
            int num2 = 2 * arr[p2];
            int num3 = 3 * arr[p3];
            int num5 = 5 * arr[p5];
            int min = getMin(num2, num3, num5);
            if(num2 == min){
                p2 ++;
                arr[i] = num2;
            }
            if(num3 == min){
                p3 ++;
                arr[i] = num3;
            }
            if(num5 == min){
                p5++;
                arr[i] = num5;
            }
        }

        return arr[arr.length - 1];
    }

    public int getMin(int a, int b, int c){
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}
