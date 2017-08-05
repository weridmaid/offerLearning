package offer02;

public class strReplacement {
    public static String  replaceSpace(StringBuffer str) {
        if (str==null)
        {return null;}
        else
        {
            StringBuffer newstr=new StringBuffer();
            for (int i=0;i<str.length();i++) {
                if (str.charAt(i) == ' ') {
                    newstr.append("%20");
                }
                else {
                    newstr.append(String.valueOf(str.charAt(i)));
                }
            }
            return newstr.toString();
        }
    }

    public static void main(String args[]){
        StringBuffer s=new StringBuffer();
        s.append("We Are Happy");
        String replaceStr=replaceSpace(s);
        System.out.println(replaceStr);

    }

}
