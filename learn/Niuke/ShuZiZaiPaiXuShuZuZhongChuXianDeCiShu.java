package Niuke;

/***
 * 先利用二分查找找到目标数字
 * 找不到就返回0，找到了就进行左右遍历
 */
public class ShuZiZaiPaiXuShuZuZhongChuXianDeCiShu {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length == 0){
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while(low<high){
            int mid = (low + high) >>> 1;
            if(array[mid] < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        int count = 0;
        if(array[low] != k){
            return count;
        }
        int p = low;
        while(p >= 0 && array[p] == k){
            p--;
            count ++;
        }
        p = low + 1;
        while(p<array.length && array[p] == k){
            p++;
            count ++;
        }
        return count;
    }
}
