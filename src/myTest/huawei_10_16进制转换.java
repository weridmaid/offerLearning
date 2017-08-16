package myTest;

/**
 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 输入描述:
 输入一个十六进制的数值字符串。
 输出描述:
 输出该数值的十进制字符串。
 输入例子1:
 0xA
 输出例子1:
 10
 */

import java.util.Scanner;

public class huawei_10_16进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String input = sc.next();

            String ans = input.substring(2);

            System.out.println(Integer.parseInt(ans, 16));


        }

    }

}