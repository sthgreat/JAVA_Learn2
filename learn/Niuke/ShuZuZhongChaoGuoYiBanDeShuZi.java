package Niuke;

/***
 * 数组中超过一半的数字
 * 定义一个竞技场，支持者进入若发现当前占据竞技场的不是自己人，就带走一个对方的人
 * 最后剩下的人还需要判断一下是否真的是大于数组的一半
 */
public class ShuZuZhongChaoGuoYiBanDeShuZi {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int king = array[0];
        int count = 1;

        for(int i = 1;i<array.length;i++){
            if(count == 0){
                count ++;
                king = array[i];
                continue;
            }

            if(array[i] == king){
                count ++;
            }else{
                count --;
            }
        }
        int num = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == king){
                num ++;
            }
        }

        if(count > 0 && num > array.length/2){
            return king;
        }else{
            return 0;
        }
    }
}