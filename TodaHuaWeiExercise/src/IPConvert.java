import java.util.Scanner;

public class IPConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            String input2 = scanner.next();
            System.out.println(ipToInteger(input));
            System.out.println(integerToIP(input2));
        }
    }
    public static String ipToInteger(String s){
        if(null == s || s.equals("")){
            return s;
        }
        String[] strings = s.split("\\.");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            String temp = Integer.toBinaryString(Integer.valueOf(strings[i]));
            temp = String.format("%08d",Integer.valueOf(temp));
            stringBuffer.append(temp);
        }
        Integer res = Integer.valueOf(stringBuffer.toString(),2);
        return String.valueOf(res);
    }
    public static String integerToIP(String s){
        if(null == s || s.equals("")){
            return s;
        }
        Integer input = Integer.valueOf(s);
        String  inputBan = Integer.toString(input,2);
        StringBuffer stringBuffer = new StringBuffer();
        if(inputBan.length()<32){
            for (int i = 0; i <(32-inputBan.length()) ; i++) {
                stringBuffer.append("0");
            }
        }
        inputBan = stringBuffer.append(inputBan).toString();
        stringBuffer.delete(0,stringBuffer.length());
        stringBuffer.append(Integer.valueOf(inputBan.substring(0,8),2)).append(".")
                .append(Integer.valueOf(inputBan.substring(8,16),2)).append(".")
                .append(Integer.valueOf(inputBan.substring(16,24),2)).append(".")
                .append(Integer.valueOf(inputBan.substring(24,32),2));
        return stringBuffer.toString();
    }
}
