package offer02;
import java.util.Stack;
/**
 * Created by Bella on 2017/8/3.
 */
public class twoStacktoLine {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
       //每次push一定是放在stack1里
        public void push(int node) {
                        stack1.push(node);
        }
        //每次POP，若stack2为空就从stack1开始操作，先放入stack2直到最后一个真正地进行pop；
        //若stack2不为空，就直接在stack2上进行pop
        public int pop() {
                int re ;
                if (stack2.size()==0 && stack1.size()==0){
                        return 0;
                }
                else if (stack2.size()==0){
                        while (stack1.size()>1){
                                re=stack1.pop();
                                stack2.push(re);
                        }
                        re=stack1.pop();
                        return re;
                }
                else {
                        re=stack2.pop();
                        return re;
                }
        }

        public static void main(String[] args) {
                twoStacktoLine test=new twoStacktoLine();
                test.push(1);
                test.push(2);
                test.push(3);
                int a =test.pop();
                int b =test.pop();
                test.push(4);
                int c =test.pop();
                test.push(5);
                int d =test.pop();
                int e =test.pop();
                System.out.println(a+","+b+","+c+","+d+","+e);
        }
}
