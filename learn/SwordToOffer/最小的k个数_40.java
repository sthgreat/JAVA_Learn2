package SwordToOffer;


/***
 * 使用快排的思想实现
 */
public class 最小的k个数_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        function(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    public void function(int[] arr, int start, int end, int k){
        int target = arr[start];
        int left = start;
        int right = end;
        while(left < right){
            while(right > left && arr[right] > target){
                right --;
            }
            while(left < right && arr[left] < target){
                left ++;
            }
            if(arr[left] == arr[right] && left < right){
                left ++;
            }else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        if(left < k - 1 && left + 1 < arr.length){
            function(arr, left + 1, end, k);
        }else if(left > k - 1 && left - 1 >= 0){
            function(arr, start, left - 1, k);
        }else{
            return;
        }
    }
}