package SwordToOffer;

public class 剑指Offer_17_打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int num = 0;
        int l = 1;
        while(n > 0){
            num = num + 9*l;
            l *= 10;
            n -= 1;
        }
        int[] ans = new int[num];
        for(int i = 1;i<=num;i++){
            ans[i - 1] = i;
        }
        return ans;
    }
}
