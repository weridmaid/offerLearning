package offer03;
import java.util.Stack;
/**
 * Created by Bella on 2017/8/7.
 */
class ListNode{
    ListNode next=null;
    int val;
    ListNode(int val) {
        this.val = val;
    }
}
public class ch03 {
    //题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        int[] newarray=new int[array.length];
        if(array.length!=0){
            int index_start=0;
            int index_end=array.length-1;
            int alength=array.length-1;
            for(int i=0;i<array.length;i++){
                if(array[i]%2==1){
                    newarray[index_start]=array[i];
                    index_start++;
                }
                if(array[alength-i]%2==0){
                    newarray[index_end]=array[alength-i];
                    index_end--;

                }
            }
        }
        //这里注意！数组copy可用for循环，或者 System.arraycopy()等，不能直接赋值相等。
        System.arraycopy(newarray, 0, array , 0, array.length);
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }



    //题目：输入一个链表，输出该链表中倒数第k个结点。方法一：强解法
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode node=head;
        int count=1;
        if(head == null || k <= 0){
            return null;
        }
        while (node.next!=null){
            count++;
            node=node.next;
        }
        if(k>count){return null;}
        else {
            int check=1;
            node=head;
            while (check!=(count+1-k)){
                node=node.next;
                check++;
            }
            return node;
        }
    }
    //题目：输入一个链表，输出该链表中倒数第k个结点。方法一：用栈的先进后出
    public ListNode FindKthToTail_1(ListNode head,int k) {
        ListNode result = null;
        if(head == null || k <= 0){
            return null;
        }
        Stack<ListNode> s = new Stack<>();
        while(head != null){
            s.push(head);
            head = head.next;
        }
        for(int i = 0 ; i < k ; i ++){
            if(!s.isEmpty()){
                result = s.pop();
            }else{
                result = null;
            }
        }
        return result;
    }


    public static void main(String[] args){
//        int[] array={1,2,3,4,5};
        ch03 test=new ch03();
//        test.reOrderArray(array);
        //题目：输入一个链表，输出该链表中倒数第k个结点。
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        int k=1;
        //方法一
        ListNode node=test.FindKthToTail(node1,k);
        System.out.println(node.val);
        //方法二
        ListNode zz=test.FindKthToTail_1(node1,3);
        System.out.println(zz.val);

    }
}
