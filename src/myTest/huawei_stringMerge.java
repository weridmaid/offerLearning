package myTest;

/**
 字符串合并处理
 按照指定规则对输入的字符串进行处理。
 详细描述：
 将输入的两个字符串合并。
 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 对排训后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，
 则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。
 如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’；
 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”


        输入描述:
        输入两个字符串
        输出描述:
        输出转化后的结果
        输入例子:
        dec fab
        输出例子:
        5D37B
 */
import java.util.*;
public class huawei_stringMerge{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s1 = in.next();
            String s2 = in.next();
            String s = s1 + s2;
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            for(int i=0;i<s.length();i++){
                if(i%2==0){
                    sb1.append(s.charAt(i));
                }else{
                    sb2.append(s.charAt(i));
                }
            }
            char[] chs1 = sb1.toString().toCharArray();
            char[] chs2 = sb2.toString().toCharArray();
            Arrays.sort(chs1);
            Arrays.sort(chs2);


            char [] cha = new char[chs1.length+chs2.length];
            int j = 0, k = 0;
            for (int i=0; i<cha.length; i++)
            {
                if (i%2 == 0)
                {
                    cha[i] = chs1[j];
                    j++;
                }
                else
                {
                    cha[i] = chs2[k];
                    k++;
                }

            }

            for (int i=0; i<cha.length; i++)
            {
                cha[i] = change(cha[i]);
            }

            System.out.println(cha);
        }

        in.close();
    }

    //     不明觉厉
    public static char change(char a) {
        char res;
        switch (a) {
            case '0': res='0';break;
            case '1': res='8';break;
            case '2': res='4';break;
            case '3': res='C';break;
            case '4': res='2';break;
            case '5': res='A';break;
            case '6': res='6';break;
            case '7': res='E';break;
            case '8': res='1';break;
            case '9': res='9';break;

            case 'A': res='5';break;
            case 'B': res='D';break;
            case 'C': res='3';break;
            case 'D': res='B';break;
            case 'E': res='7';break;
            case 'F': res='F';break;

            case 'a': res='5';break;
            case 'b': res='D';break;
            case 'c': res='3';break;
            case 'd': res='B';break;
            case 'e': res='7';break;
            case 'f': res='F';break;
            default :res=a;
        }
        return res;
    }
}

