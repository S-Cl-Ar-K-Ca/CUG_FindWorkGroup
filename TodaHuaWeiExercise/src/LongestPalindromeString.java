import java.util.Scanner;
/*
* 寻找最长回文字符串的长度
* */
public class LongestPalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            //System.out.println(findLPS(input));
            System.out.println(findLPS(input).length());
        }
    }
    public static String findPalinString(String s,int left,int right){
        while (left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    public static String findLPS(String s){
        if(null == s|| s.equals("")){
            return s;
        }
        String res = "";
        String string;
        for (int i = 0; i < s.length()-1; i++) {
            string = findPalinString(s,i,i);
            res = res.length()>string.length()?res:string;
            string = findPalinString(s,i,i+1);
            res = res.length()>string.length()?res:string;
        }
        return res;
    }
}
