package offer04;

/**
 * Created by Bella on 2017/8/14.
 */

import java.util.Stack;
//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
//解题思路：设置一个辅助栈：minStack，存放对应栈的最小值

public class ch4_stackMin extends Stack<Integer> {
    private Stack<Integer> minStack=new Stack<Integer>();
    private Stack<Integer> dataStack=new Stack<Integer>();
    public void push(int node) {
        if(dataStack.size()==0||node<minStack.peek()){
            minStack.push(node);
        }
        else{
            int top=minStack.peek();
            minStack.push(top);
        }
        dataStack.push(node);
    }
    public Integer pop() {
        int val=dataStack.pop();
        minStack.pop();
        return val;
    }
    public int min() {
        int minValue=minStack.pop();
        minStack.push(minValue);
        return minValue;
    }

    public static void main(String[] args) {
        ch4_stackMin test=new ch4_stackMin();
        int a=1;
        int b=2;
        int c=3;
        test.push(a);
        test.push(b);
        test.push(c);
        test.pop();
        int min=test.min();
        System.out.println(min);

    }
}
