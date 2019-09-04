import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SentenceCharSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuffer stringBuffer = new StringBuffer();
        while ((input = bufferedReader.readLine())!= null && !input.equals("")){
            stringBuffer.append(charSort(input)).append("\n");
        }
        System.out.print(stringBuffer.toString());
    }

    public static  String  charSort(String sentence){
        if(null == sentence){
            return null;
        }
        char[] chars = sentence.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        List<Character> charList = new ArrayList<>();
        for (char c: chars) {
            if(Character.isLetter(c)){
                charList.add(c);
            }
        }
        Collections.sort(charList, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1)-Character.toLowerCase(o2);
            }
        });
        int count = 0;
        for (char c:chars) {
            if(Character.isLetter(c) && count < charList.size()){
                stringBuffer.append(String.valueOf(charList.get(count)));
                count++;
            }else {
                stringBuffer.append(String.valueOf(c));
            }
        }
        return stringBuffer.toString();
    }
}
