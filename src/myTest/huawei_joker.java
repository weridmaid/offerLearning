package myTest;

/**
 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）:)
 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如：4 4 4 4-joker JOKER
 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR
 基本规则：
 （1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
 （3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 （4）输入的两手牌不会出现相等的情况。
 答案提示：
 （1）除了炸弹和对王之外，其他必须同类型比较。
 （2）输入已经保证合法性，不用检查输入是否是合法的牌。
 （3）输入的顺子已经经过从小到大排序，因此不用再排序了.
 输入描述:
 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如4 4 4 4-joker JOKER。
 输出描述:
 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。
 输入例子1:
 4 4 4 4-joker JOKER
 输出例子1:
 joker JOKER
 */
//只能通过80%
import java.util.*;
public class huawei_joker {


        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            String[] as=s.split("-");
            String[] AString=as[0].split(" ");
            String[] APut=new String[AString.length];
            String[] BString=as[1].split(" ");
            String[] BPut=new String[BString.length];
            int Alen=AString.length;
            int Blen=BString.length;

            //将要输出的值给put对象
            for(int i=0;i<Alen;i++){
                APut[i]=AString[i];
            }
            for(int i=0;i<Blen;i++){
                BPut[i]=BString[i];
            }

            //转换jqka
            for(int i=0;i<Alen;i++){
                if(AString[i].equals("J"))
                    AString[i]="11";
                if(AString[i].equals("Q"))
                    AString[i]="12";
                if(AString[i].equals("K"))
                    AString[i]="13";
                if(AString[i].equals("A"))
                    AString[i]="14";
                if(AString[i].equals("2"))
                    AString[i]="15";

            }
            for(int i=0;i<Blen;i++){
                if(BString[i].equals("J"))
                    BString[i]="11";
                if(BString[i].equals("Q"))
                    BString[i]="12";
                if(BString[i].equals("K"))
                    BString[i]="13";
                if(BString[i].equals("A"))
                    BString[i]="14";
                if(BString[i].equals("2"))
                    BString[i]="15";
            }

            switch(Alen){
                //当一手为1张牌
                case 1:{
                    //二手是王炸
                    if(Blen==2&&BString[0].equals("joker")&&BString[1].equals("JOKER")){
                        System.out.println("joker JOKER");
                        break;
                    }

                    else if(Blen==2&&BString[0].equals("JOKER")&&BString[1].equals("joker")){
                        System.out.println("JOKER joker");
                        break;
                    }
                    //二手是炸
                    else if(Blen==4){
                        for(int i=0;i<Blen-1;i++)
                            System.out.print(BPut[i]+" ");
                        System.out.println(BPut[Blen-1]);
                        break;
                    }
                    else if(Blen==1){
                        if(AString[0].equals("JOKER")||BString[0].equals("JOKER")){
                            System.out.println("JOKER");
                            break;
                        }
                        if(AString[0].equals("joker")||BString[0].equals("joker")){
                            System.out.println("joker");
                            break;
                        }

                        int cha=Integer.parseInt(AString[0])-Integer.parseInt(BString[0]);
                        if(cha>0)
                            System.out.println(APut[0]);
                        else
                            System.out.println(BPut[0]);
                        break;
                    }
                    else {
                        System.out.println("ERROR");
                        break;
                    }
                }

                case 2:{
                    //一手是王炸
                    if(AString[0].equals("joker")&& AString[1].equals("JOKER")){
                        System.out.println("joker JOKER");
                        break;
                    }
                    else if(AString[0].equals("JOKER")&& AString[1].equals("joker")){
                        System.out.println("JOKER joker");
                        break;
                    }
                    //二手是王炸
                    else if(Blen==2&&BString[0].equals("joker")&&BString[1].equals("JOKER")){
                        System.out.println("joker JOKER");
                        break;
                    }

                    else if(Blen==2&&BString[0].equals("JOKER")&&BString[1].equals("joker")){
                        System.out.println("JOKER joker");
                        break;
                    }
                    //二手是炸
                    else if(Blen==4){
                        for(int i=0;i<Blen-1;i++)
                            System.out.print(BPut[i]+" ");
                        System.out.println(BPut[Blen-1]);
                        break;
                    }
                    else if(Blen==2){
                        int A=Integer.parseInt(AString[0])+Integer.parseInt(AString[1]);
                        int B=Integer.parseInt(BString[0])+Integer.parseInt(BString[1]);
                        if(A>B){
                            System.out.println(APut[0]+" "+APut[1]);
                            break;
                        }
                        else{
                            System.out.println(BPut[0]+" "+BPut[1]);
                            break;
                        }
                    }
                    else {
                        System.out.println("ERROR");
                        break;
                    }
                }

                case 3:{
                    //二手是王炸
                    if(Blen==2&&BString[0].equals("joker")&&BString[1].equals("JOKER")){
                        System.out.println("joker JOKER");
                        break;
                    }

                    else if(Blen==2&&BString[0].equals("JOKER")&&BString[1].equals("joker")){
                        System.out.println("JOKER joker");
                        break;
                    }
                    //二手是炸
                    else if(Blen==4){
                        for(int i=0;i<Blen-1;i++)
                            System.out.print(BPut[i]+" ");
                        System.out.println(BPut[Blen-1]);
                        break;
                    }
                    else if(Blen==3){
                        int A=Integer.parseInt(AString[0])+Integer.parseInt(AString[1])+Integer.parseInt(AString[2]);
                        int B=Integer.parseInt(BString[0])+Integer.parseInt(BString[1])+Integer.parseInt(BString[2]);
                        if(A>B){
                            System.out.println(APut[0]+" "+APut[1]+" "+APut[2]);
                            break;
                        }
                        else {
                            System.out.println(BPut[0]+" "+BPut[1]+" "+BPut[2]);
                            break;
                        }
                    }
                    else {
                        System.out.println("ERROR");
                        break;
                    }
                }
                case 4:{
                    //二手是王炸
                    if(Blen==2&&BString[0].equals("joker")&&BString[1].equals("JOKER")){
                        System.out.println("joker JOKER");
                        break;
                    }

                    else if(Blen==2&&BString[0].equals("JOKER")&&BString[1].equals("joker")){
                        System.out.println("JOKER joker");
                        break;
                    }
                    else if(Blen==4){
                        int A=Integer.parseInt(AString[0]);
                        int B=Integer.parseInt(BString[0]);
                        if(A>B){
                            System.out.println(APut[0]+" "+APut[0]+" "+APut[0]+" "+APut[0]);
                            break;
                        }
                        else{
                            System.out.println(BPut[0]+" "+BPut[0]+" "+BPut[0]+" "+BPut[0]);
                            break;
                        }
                    }
                    else {
                        System.out.println("ERROR");
                        break;
                    }
                }
                case 5:{
                    //二手是王炸
                    if(Blen==2&&BString[0].equals("joker")&&BString[1].equals("JOKER")){
                        System.out.println("joker JOKER");
                        break;
                    }

                    else if(Blen==2&&BString[0].equals("JOKER")&&BString[1].equals("joker")){
                        System.out.println("JOKER joker");
                        break;
                    }
                    //二手是炸
                    else if(Blen==4){
                        for(int i=0;i<Blen-1;i++)
                            System.out.print(BPut[i]+" ");
                        System.out.println(BPut[Blen-1]);
                        break;
                    }
                    else if(Blen==5){
                        int A=Integer.parseInt(AString[0]);
                        if(A==14)
                            A=1;
                        if(A==15)
                            A=2;

                        int B=Integer.parseInt(BString[1]);
                        if(A>B){
                            System.out.println(APut[0]+" "+APut[1]+" "+APut[2]+" "+APut[3]+" "+APut[4]);
                            break;
                        }
                        else{
                            System.out.println(BPut[0]+" "+BPut[1]+" "+BPut[2]+" "+BPut[3]+" "+BPut[4]);
                            break;
                        }
                    }
                    else {
                        System.out.println("ERROR");
                        break;
                    }
                }

            }//switch
        }
    }

