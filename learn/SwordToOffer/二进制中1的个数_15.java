package SwordToOffer;

public class 二进制中1的个数_15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count ++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
