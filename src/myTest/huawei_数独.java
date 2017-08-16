package myTest;

/**
 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
 输入描述:
 输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
 输出描述:
 输出九行，每行九个空格隔开的数字，为解出的答案。
 测试用例:
 7 2 6 9 0 4 0 5 1
 0 8 0 6 0 7 4 3 2
 3 4 1 0 8 5 0 0 9
 0 5 2 4 6 8 0 0 7
 0 3 7 0 0 0 6 8 0
 0 9 0 0 0 3 0 1 0
 0 0 0 0 0 0 0 0 0
 9 0 0 0 2 1 5 0 0
 8 0 0 3 0 0 0 0 0
 对应输出应该为:
 7 2 6 9 3 4 8 5 1
 5 8 9 6 1 7 4 3 2
 3 4 1 2 8 5 7 6 9
 1 5 2 4 6 8 3 9 7
 4 3 7 1 9 2 6 8 5
 6 9 8 5 7 3 2 1 4
 2 1 5 8 4 6 9 7 3
 9 6 3 7 2 1 5 4 8
 8 7 4 3 5 9 1 2 6
 */
import java.util.Scanner;

public class huawei_数独{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int[][] A = new int[9][9];

            for(int i =0;i<9;i++){
                for(int j =0;j<9;j++){
                    A[i][j] = in.nextInt();
                }

            }
            solvesudoku(A,0);
            for(int i =0;i<9;i++){
                for(int j =0;j<9;j++){
                    if(j != 8)
                        System.out.print(A[i][j] + " ");
                    else
                        System.out.print(A[i][j]);
                }
                if(i != 8)
                    System.out.println();
            }
        }
    }
    static boolean solvesudoku(int[][] sd,int index){
        if(index == 81)
            return true;
        int x = index/9;
        int y = index%9;
        if(sd[x][y]==0){
            for(int n=1;n<=9;n++){
                sd[x][y] = n;
                if(CheckrowAndcol(sd,x,y,n) && CheckGrid(sd,x,y,n))
                    if(solvesudoku(sd,index+1))
                        return true;
                sd[x][y] = 0;
            }
        }else
            return solvesudoku(sd,index+1);
        return false;

    }
    // 判断 n 所在的行列是否包含 n
    static boolean CheckrowAndcol(int[][] sd,int x ,int y,int n){
        // x 行
        for(int j=0;j<9;j++){
            if(j!=y && sd[x][j] ==n  )
                return false;
        }
        // y列
        for(int i=0;i<9;i++){
            if(i!=x && sd[i][y]==n )
                return false;
        }
        return true;
    }
    // 判断所在的方格是否包含 n
    static boolean CheckGrid(int[][] sd,int x,int y,int n){
        // 根据x y的坐标求其所在方格的左上坐标和右下坐标表示不好想。
        for(int i = (x/3)*3;i<(x/3+1)*3;i++){
            for(int j=(y/3)*3;j<(y/3+1)*3;j++){
                if(i!=x && j!=y && sd[i][j]==n)
                    return false;
            }
        }
        return true;
    }
}