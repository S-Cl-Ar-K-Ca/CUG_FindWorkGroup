import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReverseIntSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            System.out.println(reverse(input));
        }
    }
    public  static  String  reverseInt(int a){
        String input = String.valueOf(a);
        StringBuffer stringBuffer = new StringBuffer(input);
        input = stringBuffer.reverse().toString();
        StringBuffer res = new StringBuffer();
        Set set = new HashSet();
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String reverseInt2(int a){
        String s = String.valueOf(a);
        return reverseStr(s);
    }

    public  static String reverseStr(String s){
        if (s.equals("") || null == s){
            return "";
        }
        return s.charAt(s.length()-1)+reverseStr(s.substring(0,s.length()-1));
    }

    public static String reverse(String sentence){
        String []words = sentence.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = words.length-1; i >= 0; i--) {
            stringBuffer.append(words[i]).append(" ");
        }
        return stringBuffer.toString();
    }
}
