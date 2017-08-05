package offer02;
import java.util.Arrays;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
public class reconstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            TreeNode root=new TreeNode();
            if (pre==null ||in==null||pre.length==0||in.length==0)
                return null;
            else if(pre.length!=in.length){
                System.out.println("长度不一样，非法的输入");
            }
            else {
                    for (int i=0;i<in.length;i++) {
                        if (in[i]==pre[0]){
                            root.val=pre[0];
                            root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1, i+1), Arrays.copyOfRange(in, 0, i));
                            root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1, pre.length),Arrays.copyOfRange(in, i+1, in.length));
                        }
                    }
                }
             System.out.println( root.val);
             return root;
    }
    public static void main (String args[]){
        int[] a={1,2,4,7,3,5,6,8};
        int[] b={4,7,2,1,5,3,8,6};
//        int[] a={1,2,3,4,5,6,7};
//        int[] b={3,2,4,1,6,5,7};
        reconstructBinaryTree test=new reconstructBinaryTree();
        TreeNode treeNode=test.reConstructBinaryTree(a,b);
    }
}
