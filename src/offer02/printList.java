package offer02;
import java.util.ArrayList;
import java.util.*;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
public class printList {

    public static void main (String args[])
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;

        ArrayList<Integer> array=printListFromTailToHead(node1);
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }
    }

//    使用非递归的方式，栈；输入的listNode就是链表的headNode
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        Stack<ListNode> stack=new Stack<ListNode>();
        while(listNode!=null){
            stack.push(listNode);
            listNode=listNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop().data);
        }
        return list;
    }
}
