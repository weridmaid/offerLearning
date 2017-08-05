package offer02;

/**
 * Created by Bella on 2017/8/5.
 */
public class fibonacci {
    public int  Fibonacci(int n) {
       int value=0;
        if (n==0)
            value=0;
        if(n==1)
            value=1;
        if(n>1){
            //注意这题用递归的话效率很差！！留意f1,f2的交叉用法
            int f1=0;
            int f2=1;
            for (int i=2;i<=n;i++){
                value=f1+f2;
                f1=f2;
                f2=value;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int n=38;
        fibonacci test=new fibonacci();
        int value=test.Fibonacci(n);
        System.out.println(value);
    }
}
