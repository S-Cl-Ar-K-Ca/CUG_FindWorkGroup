import java.util.Scanner;

public class SentenceWordsReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            StringBuffer stringBuffer = new StringBuffer();
            input = wordClear(input);
            String[] words = input.split(" ");
            for (int i = words.length-1; i >=0 ; i--) {
                stringBuffer.append(words[i].trim()).append(" ");
            }
            System.out.print(stringBuffer.toString().trim());
        }
    }
    public static String wordClear(String s){
        String regex = "[^(a-zA-Z)]";
        s = s.replaceAll(regex," ");
        return s;
    }
}
