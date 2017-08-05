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
    //用二分查找法实现
    public int minNumberInRotate(int [] array,int length) {

        //异常处理
        if (array==null||length<=0){
            return 0;
        }
        int start=0;
        int end=length-1;
        int indexmid=start;
        while (array[start]>=array[end]){
            if (end-start==1){
                indexmid=end;
                break;
            }
            indexmid=(start+end)/2;
            if(array[start]<array[indexmid]){
                start=indexmid;
            }
            else if(array[end]>array[indexmid]){
                end=indexmid;
            }
        }
        return array[indexmid];
    }

    public static void main(String[] args) {
        int[] list={4,5,6,7,2,3};
        minNumberRotateArray test=new minNumberRotateArray();
        int minNum1=test.minNumberInRotateArray(list);
        System.out.println(minNum1);

        int minNum2=test.minNumberInRotate(list,list.length);
        System.out.println(minNum2);

    }
}
