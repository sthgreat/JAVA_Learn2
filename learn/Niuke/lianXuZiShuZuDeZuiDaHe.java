package Niuke;

/***
 * 连续子数组的最大和：
 * 使用动态规划来解决问题，判断当前值array[i]与之前的最大连续子数组之和array[i] + record[i]
 * 哪个大，将大的那个记录为新的record
 */
public class lianXuZiShuZuDeZuiDaHe {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0){
            return 0;
        }
        int[] record = new int[array.length];
        record[0] = array[0];
        for(int i = 1;i<array.length;i++){
            record[i] = Math.max(array[i] + record[i - 1], array[i]);
        }
        int max = record[0];
        for(int i = 1;i<record.length;i++){
            max = Math.max(max, record[i]);
        }
        return max;
    }
}
