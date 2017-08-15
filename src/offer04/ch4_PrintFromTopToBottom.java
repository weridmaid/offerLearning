package offer04;

/**
 * Created by Bella on 2017/8/14.
 */

import utils.TreeNode;

import java.util.*;

//广度优先遍历
//解题思路：按层把node放入队列里，先进先出
//Queue方法里有添加有add(),offer();移除有remove(),poll();
//add()和remove()方法在失败的时候会抛出异常(不推荐)
public class ch4_PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> lists=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root!=null){
            queue.offer(root);
            TreeNode node =root;
            while (queue.size()!=0){
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                lists.add(queue.poll().val);
                node=queue.peek();
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        TreeNode node1=new TreeNode(6);
        TreeNode node2=new TreeNode(10);

        TreeNode node3=new TreeNode(5);
        TreeNode node4=new TreeNode(7);

        TreeNode node5=new TreeNode(9);
        TreeNode node6=new TreeNode(11);
        root.left=node1;
        root.right=node2;

        node1.left=node3;
        node1.right=node4;

        node2.left=node5;
        node2.right=node6;

        ch4_PrintFromTopToBottom test=new ch4_PrintFromTopToBottom();
        ArrayList list=test.PrintFromTopToBottom(root);
        System.out.println(list);
    }
}
