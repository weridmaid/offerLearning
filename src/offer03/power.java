package offer03;

/**
 * Created by Bella on 2017/8/7.
 */
public class power {
    public double Power(double base, int exponent) {
        double value=1;
        if(exponent>0){
            while (exponent!=0){
                  value=value*base;
                  --exponent;
            }}
        if(exponent<0){
            while (exponent!=0){
                value=value*base;
                ++exponent;
            }
            value=1/value;
        }
        return value;
    }

    public static void main(String[] args) {
        double base=2.0;
        int exponent=-5;
        power test=new power();
        double value=test.Power(base,exponent);
        System.out.println(value);
    }
}
