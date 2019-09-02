import java.util.Scanner;

/*
* Problem:计算字符串最后一个单词的长度，单词以空格隔开。
* */
public class StringLastSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(getLength(input));
    }

    public static int getLength(String s){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        s = stringBuffer.reverse().toString();
        if(s.contains(" ")){
            return s.indexOf(" ");
        }
        return s.length();
    }
}
