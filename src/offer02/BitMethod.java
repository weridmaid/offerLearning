package offer02;

/**
 * Created by Bella on 2017/8/7.
 */
public class BitMethod {

    // 利用Java内置toBinaryString方法来实现
    public static int numberOfOne1(int n) {
        int count = 0;
        String str = Integer.toBinaryString(n);
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    /*
     * 利用位运算来实现 思路： 将n与n-1做与运算，会把最右边的1去掉。 比如： 1100 & 1011 = 1000 ，即 12 & 11 = 8
     * 再利用计算器count++计算出有多少个 1 即可。
     */
    public static int numberOfOne2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println("------------------第一种方法------------------");
        System.out.println("数字 3 的二进制表示中有 " + numberOfOne1(3) + "个1");
        System.out.println("数字 -3 的二进制表示中有 " + numberOfOne1(-3) + "个1");

        System.out.println("\n------------------第二种方法------------------");
        System.out.println("数字 3 的二进制表示中有 " + numberOfOne2(3) + "个1");
        System.out.println("数字 -3 的二进制表示中有 " + numberOfOne2(-3) + "个1");
    }

}

