package offer04;

import java.util.ArrayList;

/**
 * Created by Bella on 2017/8/13.
 */
public class ch4_printMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        if(matrix==null)
            return null;
        int start=0;
        if(matrix[0].length==1){
            for(int i=0;i<matrix.length;i++){list.add(matrix[i][0]);}
        }
        else {
        while(matrix[0].length>start*2&&matrix.length>start*2){
            ArrayList<Integer> a=printOneCircle(matrix,start);
            for(int i=0;i<a.size();i++)
            {
                list.add(a.get(i));
            }
            start++;
        }}
        return list;
    }
    private ArrayList<Integer> printOneCircle(int[][] array, int start) {
        ArrayList<Integer> list=new ArrayList<>();
        //从左到右打印一行
        for(int i=start;i<array[0].length-start;i++){
            list.add(array[start][i]);
            System.out.print(array[start][i]+" ");
        }
        //从上到下打印一列
        if(array.length-1-start>start){
            for(int i=start+1;i<array.length-start-1;i++){
                list.add(array[i][array[0].length-1-start]);
                System.out.print(array[i][array[0].length-1-start]+" ");
            }
        }
        //从右到左打印一行
        if(array[0].length-start-1>start && array.length-start-1>start)
        {
            for(int i=array.length-start-1;i>start;i--)
            {
                list.add(array[array.length-start-1][i]);
                System.out.print(array[array.length-start-1][i]+" ");
            }
        }
        //从下到上打印一列
        if(array.length-1-start>start && array[0].length-1-start>start)
        {
            for(int i=array.length-start-1;i>start;i--)
            {
                list.add(array[i][start]);
                System.out.print(array[i][start]+" ");
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
         ch4_printMatrix test=new ch4_printMatrix();
        ArrayList array=test.printMatrix(matrix);
        System.out.println(array);

        ;
    }
}
