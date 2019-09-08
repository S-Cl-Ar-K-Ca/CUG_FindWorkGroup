import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DeleteLeastChar {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null ;
        StringBuffer stringBuffer = new StringBuffer();
        while ((input = bufferedReader.readLine())!=null && !input.equals("")){
            stringBuffer.append(deleteLeastchar(input)).append("\n");
        }
        System.out.print(stringBuffer.toString());
    }

    public static String deleteLeastchar(String s){
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(!map.keySet().contains(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        Collection<Integer> values = map.values();
        int minValue = Collections.min(values);
        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i]) == minValue){
                s = s.replaceAll(String.valueOf(chars[i]),"");
            }
        }
        return  s;
    }
}
