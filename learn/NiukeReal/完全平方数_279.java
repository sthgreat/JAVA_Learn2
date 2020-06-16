package NiukeReal;

public class 完全平方数_279 {
    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for(int i = 2;i<=n;i++){
            int j = 2;
            arr[i] = arr[i - 1] + 1;
            while(i / (j * j) >= 0 && i - j*j >= 0){
                if(i / (j*j) == 0){
                    arr[i] = 1;
                }else{
                    arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
                }
                j++;
            }
        }
        // for(int k : arr){
        //     System.out.print(k + " ");
        // }
        // System.out.println();
        return arr[n];
    }
}
