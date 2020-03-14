package Niuke;

public class ShuZhiDeZhengShuCiFang {
    public double Power(double base, int exponent) {
        boolean flag = exponent < 0;
        if(flag){
            exponent = - exponent;
        }

        double sum = fastPower(base, exponent);

        return flag ? 1 / sum : sum ;
    }

    public double fastPower(double base, int exponent){
        if(exponent == 1){
            return base;
        }
        if(exponent == 0){
            return 1;
        }
        double sum = base;
        while(exponent != 0){
            sum *= base;
            exponent = exponent >> 1;
        }
        sum = sum *fastPower(base, exponent >> 1);
        return sum;
    }
}
