package offer02;

/**
 * Created by Bella on 2017/8/5.
 */
public class frogJumpFloor {
    //青蛙普通跳，可以跳1阶或者2阶
    public int  JumpFloor(int n) {
        int value=0;
        if (n==1)
            value=1;
        if(n==2)
            value=2;
        if(n>2){
            //注意这题用递归的话效率很差！！留意f1,f2的交叉用法
            int f1=1;
            int f2=2;
            for (int i=3;i<=n;i++){
                value=f1+f2;
                f1=f2;
                f2=value;
            }
        }
        return value;
    }
    //斐波拉契扩展题：清完变态跳；OK通过
    public int JumpFloorII(int target) {
            int value=1;
            if (target==1)
                value=1;
            if(target==2)
                value=2;
            //target==3时，value=4;因为第n阶还要考虑一下跳n布所以还要+1
            if(target>2){
                //注意这题用递归的话效率很差！！留意f1,f2的交叉用法
                for (int i=1;i<target;i++){
                    value= JumpFloorII(i)+value;
                }
            }
            return value;
    }

    public static void main(String[] args) {
        int n=3;
        frogJumpFloor test=new frogJumpFloor ();
        int value=test.JumpFloor(n);
        System.out.println(value);

        int value1=test.JumpFloorII(n);
        System.out.println(value1);
    }
}
