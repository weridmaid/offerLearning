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

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;
 public TreeNode(int val) {
 this.val = val;
 }
 }

public class ch03 {
    //题目2：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
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



    //题目3：输入一个链表，输出该链表中倒数第k个结点。方法一：强解法
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
    //题目3：输入一个链表，输出该链表中倒数第k个结点。方法二：用栈的先进后出
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
    //题目4：输入一个链表，反转链表后，输出链表的所有元素。
    //除了基本类型，class，赋等值的不同变量其实指向同一个内存
    public ListNode ReverseList(ListNode head) {
           ListNode preListNode=null;
           ListNode nowListNode=head;
           ListNode reverseNode=null;
           while (nowListNode!=null){
               ListNode nextListNode=nowListNode.next;
               if(nextListNode==null)
                   reverseNode=nowListNode;
               nowListNode.next=preListNode;
               preListNode=nowListNode;
               nowListNode=nextListNode;
            }
           return reverseNode;
    }
    //题目5：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
    //用递归来解。。。
    public ListNode Merge(ListNode list1,ListNode list2) {
          if(list1==null)
              return list2;
          else if (list2==null)
            return list1;
          ListNode mergeList=null;
          if(list1.val<list2.val){
              mergeList=list1;
              mergeList.next=Merge(list1.next,list2);
          }
          else {
              mergeList=list2;
              mergeList.next=Merge(list1,list2.next);
          }
          return mergeList;

    }
    //题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean check=false;
        if(root2!=null&&root1!=null)
        {
            if(root1.val==root2.val)
                check=DoseTreeHasSubtree(root1,root2);
            if(check==false)
                check=HasSubtree(root1.left,root2);
            if(check==false)
                check=HasSubtree(root1.right,root2);
        }
        return check;
    }
    public boolean DoseTreeHasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return DoseTreeHasSubtree(root1.left,root2.left)&&DoseTreeHasSubtree(root1.right,root2.right);
    }


    public static void main(String[] args){
        ch03 test=new ch03();


        //题2
//        int[] array={1,2,3,4,5};
//        test.reOrderArray(array);

        //题目3~5用
//        ListNode node1=new ListNode(1);
//        ListNode node2=new ListNode(2);
//        ListNode node3=new ListNode(3);
//        ListNode node4=new ListNode(4);
//        ListNode node5=new ListNode(5);
//        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        //题目3：输入一个链表，输出该链表中倒数第k个结点。
//        int k=1;
//        //方法一
//        ListNode node=test.FindKthToTail(node1,k);
//        System.out.println(node.val);
//        //方法二
//        ListNode zz=test.FindKthToTail_1(node1,3);
//        System.out.println(zz.val)
        //题4：
//        ListNode node=test.ReverseList(node1);
//        System.out.println(node.val);
        //题5：
//        ListNode node=test.Merge(node1,node4);
//        System.out.println(node.val);
        //题6：
        TreeNode nodeRoot1=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(5);
        nodeRoot1.left=node1;
        nodeRoot1.right=node2;
        node1.right=node3;


        TreeNode nodeRoot2=new TreeNode(2);
        nodeRoot2.right=node3;
        boolean check=test.HasSubtree(nodeRoot1,nodeRoot2);
        System.out.println(check);





    }
}
