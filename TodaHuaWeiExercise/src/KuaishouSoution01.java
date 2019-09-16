import java.util.Scanner;

public class KuaishouSoution01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        isWhat(input);
    }

    public static void isWhat(String input){
        boolean res = false;
        if(input.contains(".")&&!input.contains(":")){
            res = isIPV4(input);
            if (res){
                System.out.print("IPv4");
                return;
            }
        }else if(input.contains(":")&&!input.contains(".")){
            res = isIPV6(input);
            if (res){
                System.out.print("IPv6");
                return;
            }
        }
        if(!res){
                System.out.print("Neither");
        }

    }

    public static boolean isIPV4(String input){
        boolean res = true;
        String s[] = input.split("\\.");
        if(s.length==4){
            for (int i = 0; i < s.length; i++) {
                if(Integer.valueOf(s[i])<0 || Integer.valueOf(s[i])>255 ||
                        (s[i].length()>1&&Integer.valueOf(s[i]) < Math.pow(2,s[i].length()))){
                    res = false;
                    break;
                }
            }
        }else {
            res = false;
        }
        return res;
    }

    public static boolean isIPV6(String input){
        String regex = "[^(0-9a-fA-F)]";
        boolean res = true;
        String s[] = input.split(":");
        if(s.length==8){
            for (int i = 0; i < s.length; i++) {
                if(s[i].length()>4 || Integer.valueOf(s[i],16)<0||
                s[i].contains(regex)){
                    res = false;
                    break;
                }
            }
        }else {
            res = false;
        }
        return res;
    }
}
