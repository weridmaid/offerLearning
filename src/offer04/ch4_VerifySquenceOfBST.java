package offer04;

import java.util.Arrays;

/**
 * Created by Bella on 2017/8/14.
 */
//题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。
// 假设输入的数组的任意两个数字都互不相同。
public class ch4_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        boolean check=false;
        int countmin=0;
        int countmax=0;
        if(sequence.length>0){
            int root=sequence[sequence.length-1];
            for(int i=0;i<sequence.length-1;i++){
                if(sequence[i]<root&&sequence[i+1]>root){
                    if(countmin==i){
                        check=true;
                        for(int j=i+1;j<sequence.length-1;j++){
                            if(sequence[j]<root)
                                check=false;
                        }
                    }
                }
                if(sequence[i]<root)
                    countmin++;
                if(sequence[i]>root)
                    countmax++;
            }
            if(countmax==sequence.length-1||countmin==sequence.length-1)
                check=true;
        }
        return check;
    }

    public static void main(String[] args) {
        ch4_VerifySquenceOfBST test=new ch4_VerifySquenceOfBST();
//        int[] seq={5,7,6,9,11,10,8};
        int[] seq={4,6,7,5};
        boolean check=test.VerifySquenceOfBST(seq);
        System.out.println(check);


    }

}
