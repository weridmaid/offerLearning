package offer02;

/**
 * Created by Bella on 2017/8/4.
 */
import java.util.ArrayList;
public class minNumberRotateArray {
    public int minNumberInRotateArray(int [] array) {
           int minNum;
           if (array.length==0){
               minNum=0;
           }
           else {
               minNum=array[0];
              for (int i=0;i<array.length;i++){
                  if (array[i]<minNum){
                      minNum=array[i];
                      break;
                  }
                  else {minNum=array[i];}
              }
           }
          return minNum;
    }

    public static void main(String[] args) {
        int[] list={4,5,6,7,2,3};
        minNumberRotateArray test=new minNumberRotateArray();
        int minNum=test.minNumberInRotateArray(list);
        System.out.println(minNum);

    }
}
