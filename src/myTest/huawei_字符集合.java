package myTest;

/**
 输入一个字符串，求出该字符串包含的字符集合
 输入描述:
 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 输出描述:
 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 输入例子1:
 abcqweracb
 输出例子1:
 abcqwer
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class huawei_字符集合 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            printCharCollection(str);
        }//endwhile
        scan.close();
    }
    public static void printCharCollection(String str){
        char[] ch = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        Set<Character> set = new HashSet<Character>();
        int length = str.length();
        for(int i = 0 ; i < length ; i++){
            if(set.add(ch[i])){
                sb.append(ch[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
