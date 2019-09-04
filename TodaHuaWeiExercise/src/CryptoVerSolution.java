import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CryptoVerSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuffer stringBuffer = new StringBuffer();
        while ((input = bufferedReader.readLine())!=null && !input.equals("")){
            if(isLength(input) && isComplex(input) && !isRepeat(input)){
                stringBuffer.append("OK").append("\n");
            }else {
                stringBuffer.append("NG").append("\n");
            }
        }
        System.out.print(stringBuffer.toString());
    }

    public  static boolean isLength(String s){
        return s.length() > 8;
    }

    public static boolean isComplex(String s){
        int typeCount = 0;
        String[] strings = {"[a-z]","[A-Z]","[0-9]","[^a-zA-Z0-9]"};
        for (int i = 0; i <strings.length ; i++) {
            Pattern pattern = Pattern.compile(strings[i]);
            Matcher m = pattern.matcher(s);
            if(m.find()){
                typeCount++;
            }
        }
        return typeCount>=3;
    }

    public static boolean isRepeat(String s){
        for (int i = 0; i < s.length()-3; i++) {
            if(s.substring(i+3).contains(s.substring(i,i+3))){
                return true;
            }
        }
        return false;
    }
}
