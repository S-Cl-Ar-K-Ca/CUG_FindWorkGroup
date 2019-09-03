import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Crypto2PlainSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuffer stringBuffer = new StringBuffer();
        while ((input = bufferedReader.readLine())!=null && !input.equals("")){
            stringBuffer.append(crypto2Plain(input)).append("\n");
        }
        System.out.print(stringBuffer.toString());
    }
    public static String crypto2Plain(String s){
        if(null == s){
            return  null;
        }
        Map<String,Integer> regex = new HashMap<>();
        regex.put("[a-c]",2);
        regex.put("[d-f]",3);
        regex.put("[g-i]",4);
        regex.put("[j-l]",5);
        regex.put("[m-o]",6);
        regex.put("[p-s]",7);
        regex.put("[t-v]",8);
        regex.put("[w-z]",9);
        StringBuffer stringBuffer= new StringBuffer();

        for (String regexs:regex.keySet()) {
                s = s.replaceAll(regexs,String.valueOf(regex.get(regexs)));
        }
        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))){
                if(s.charAt(i) == 'Z'){
                    s = s.replace(s.charAt(i),'a');
                }else {
                    s = s.replace(s.charAt(i),(char)(Character.toLowerCase(s.charAt(i))+1));
                }
            }
        }
        return s;
    }

}
