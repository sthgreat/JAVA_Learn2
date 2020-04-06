package Niuke;

/***
 * 数组中只出现一次的数字
 * 衍生题：数组中除了一个数字以外，其他数字均出现两次
 * 利用异或的特性（0^自己 = 自己，自己^自己 = 0），遍历异或所有数，得到唯一一个出现一次的数字
 * 该题在此基础之上，得到的是两个唯一数字不相等的位数（具体到第几位），再根据这个判断条件将数组分成两个部分，
 * 每个部分执行之前衍生题的解决方法，得到两个数字。
 */
public class ShuZuZhongZhiChuXianYiCiDeShuZi {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int num = 0;
        for(int i = 0; i<array.length;i++){
            num ^= array[i];
        }
        int index = findFirst1(num);
        if(index < 0){
            return;
        }
        num1[0] = 0;
        num2[0] = 0;
        for(int i = 0 ;i<array.length;i++){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    public static int findFirst1(int num){
        if(num < 0){
            return -1;
        }
        int index = 0;
        while(num != 0){
            if((num&1)==1){//从右往左数第一个不一样的位
                return index;
            }else{
                num = num >> 1;
                index ++;
            }
        }
        return -1;
    }

    public boolean isBit1(int num, int index){
        return ((num >> index) & 1) == 1;
    }
}
