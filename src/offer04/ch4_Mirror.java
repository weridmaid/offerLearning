package offer04;
import utils.TreeNode;
//操作给定的二叉树，将其变换为源二叉树的镜像

//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}
/**
 输入描述:
 二叉树的镜像定义：源二叉树
 8
 /  \
 6   10
 / \  / \
 5  7 9 11
 镜像二叉树
 8
 /  \
 10   6
 / \  / \
 11 9 7  5
 */

public class ch4_Mirror {
    public void Mirror(TreeNode root) {
        TreeNode mirrorNode=null;
        if(root!=null){
            mirrorNode=root.left;
            root.left=root.right;
            root.right=mirrorNode;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
    //二叉树先序遍历
    public void preOrderPrint(TreeNode root){

            System.out.println(root.val);
            if (root.left!=null)
            preOrderPrint(root.left);
            if (root.right!=null)
            preOrderPrint(root.right);

    }

    public static void main(String args[]){
        ch4_Mirror test=new ch4_Mirror();
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

        test.Mirror(root);
        //先序遍历
        test.preOrderPrint(root);


    }


}
