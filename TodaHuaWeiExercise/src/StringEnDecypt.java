import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringEnDecypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println(encypt(s1));
            System.out.println(decypt(s2));
        }
        scanner.close();
    }
    public static String encypt(String s){
        if(null == s || s.equals("")){
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isLetterOrDigit(chars[i])){
                if(Character.isDigit(chars[i])){
                    if(chars[i] == '9') {
                        chars[i] = '0';
                    }else {
                        chars[i] = (char) (chars[i] + 1);
                    }
                }else {
                    if(Character.isUpperCase(chars[i])){
                        if(chars[i] == 'Z'){
                            chars[i] = 'a';
                        }else {
                            chars[i] = (char) (Character.toLowerCase(chars[i])+1);
                        }
                    }else  if(Character.isLowerCase(chars[i])){
                        if(chars[i] == 'z'){
                            chars[i] = 'A';
                        }else {
                            chars[i] = (char) (Character.toUpperCase(chars[i])+1);
                        }
                    }
                }
            }
        }

        return String.valueOf(chars);
    }
    public static String decypt(String s){
        if(null == s || s.equals("")){
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isLetterOrDigit(chars[i])){
                if(Character.isDigit(chars[i])){
                    if(chars[i] == '0') {
                        chars[i] = '9';
                    }else {
                        chars[i] = (char) (chars[i] - 1);
                    }
                }else {
                    if(Character.isUpperCase(chars[i])){
                        if(chars[i] == 'A'){
                            chars[i] = 'z';
                        }else {
                            chars[i] = (char) (Character.toLowerCase(chars[i])-1);
                        }
                    } else if(Character.isLowerCase(chars[i])){
                        if(chars[i] == 'a'){
                            chars[i] = 'Z';
                        }else {
                            chars[i] = (char) (Character.toUpperCase(chars[i])-1);
                        }
                    }
                }
            }
        }

        return String.valueOf(chars);
    }
}
