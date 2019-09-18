public class SangforSolution {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1="baba";
        String s2="caba";
        String res =LCS(s1, s2);
        System.out.println(res);
    }

    //超找连个子串中的最长公共子串
    public static String LCS(String str1, String str2)
    {
        //判断两个字符串是否为空
        if(str1==null || str2 == null)
        {		return null;   }
        if (str1.equals(" ") || str2.equals(" "))
        {  return null;	 }

        int xLen = str1.length();   // 将s1放在x轴方向 ，其串长度为列数clo，xlen
        int yLen = str2.length();  // 将s2放在y轴方向 ，其串长度为行数row，ylen
        int baseCow[]=new int [xLen];
        int curCow[] = new  int [xLen];
        int maxLen =0;
        int pos=0;
        char c=' ';

        for (int i=0;i<yLen;i++)
        {
            c =str2.charAt(i);
            for(int j=0;j<xLen;j++)
            {
                if (c==str1.charAt(j))
                {
                    if (j==0) {
                        curCow[j]=1;
                    }else {
                        curCow[j]=baseCow[j-1]+1;
                    }
                    if (maxLen<curCow[j]) {
                        maxLen=curCow[j];
                        pos =j;
                    }
                }

            }
            for (int k=0;k<xLen;k++)
            {
                baseCow[k]=curCow[k];
                curCow[k]=0;
            }
        }

        return str1.substring(pos+1-maxLen, pos+1);
    }

}
