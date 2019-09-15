import java.util.Scanner;
import java.util.Stack;

public class LaohuMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char chars[] = input.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c:chars) {
            if(c=='{'||c=='}'){
                stringBuffer.append(2);
            }else if(c=='['||c==']'){
                stringBuffer.append(1);
            }else if(c=='('||c==')'){
                stringBuffer.append(0);
            }else {
                stringBuffer.append("*");
            }
        }
        String inputTOV = stringBuffer.toString();
        isVaild(inputTOV);
    }
    public  static  void  isVaild(String s){
        if(s.length()<2 || s.contains("*")){
            System.out.println("不合规则");
            return;
        }
        s = s.replaceAll("00","");
        if(s.contains("0")){
            System.out.println("不合规则");
            return;
        }
        s = s.replaceAll("11","");
        if(s.contains("1")){
            System.out.println("不合规则");
            return;
        }
        s = s.replaceAll("22","");
        if(s.contains("2")){
            System.out.println("不合规则");
            return;
        }

        System.out.println("符合规则");
    }
}
