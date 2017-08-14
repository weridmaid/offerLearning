package offer04;

/**
 * Created by Bella on 2017/8/14.
 */
import java.util.Stack;

//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
// （注意：这两个序列的长度是相等的）
public class ch4_IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA){
        if(pushA==null||popA==null){
            return false;
        }
        int point1=0;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<popA.length;i++){
            if(!stack.isEmpty()&&stack.peek()==popA[i]){
                stack.pop();
            }else{ if(point1==pushA.length){
                return false;
            }else{
                do{ stack.push(pushA[point1++]); }while(stack.peek()!=popA[i]&&point1!=pushA.length);
                if(stack.peek()==popA[i])
                    stack.pop();
                else
                    return false;
            }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ch4_IsPopOrder test=new ch4_IsPopOrder();
        int[] A={1,2,3,4,5};
        int[] B={4,5,3,2,1};
        boolean check=test.IsPopOrder(A,B);
        System.out.println(check);
    }
}
