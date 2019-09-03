import com.sun.xml.internal.ws.encoding.HasEncoding;

import java.util.Scanner;
import java.util.logging.Level;

/**
 * 将输入的16进制hex码转换为ascii码
 * eg:
 * input = 67616d66
 * output = gbmf
 */
public class TransHex2Ascii {

    public static void main(String[] args){

        Scanner sin = new Scanner(System.in);
        String hexstr = sin.next();
        sin.close();

        int[] result = hex2int(hexstr);
        for (int item:result){
            System.out.print(item+"  ");
        }
        String ascii = transNum2Ascii(result);
        System.out.println("Ascii result:"+ascii);
    }

    public static String transNum2Ascii(int[] Num){
        StringBuffer sb = new StringBuffer();
        if (Num == null || Num.length==0){
            return "";
        }
        for (int i=0;i<Num.length;i++){
            sb.append((char)Num[i]);
        }

        return sb.toString();
    }

    /**
     * 将16进制字符串转换为数字
     *
     * @param hexstr
     * @return
     */
    public static int[] hex2int(String hexstr){

        int length;

        if (hexstr.length()%2==0){
            length = hexstr.length()/2;
        }else
            length = hexstr.length()/2 + 1;

        int[] result = new int[length];

        for (int i=0;i<length-1;i++){

            String str = hexstr.substring(i*2,i*2+2);

            int up = transStr2Num(str.substring(0,1));
            int down = transStr2Num(str.substring(1,2));
            result[i] = up*16+down;
        }
        if (hexstr.length()%2!=0){
            result[length-1] = transStr2Num(hexstr.substring(hexstr.length()-1));
        }else{
            String string = hexstr.substring(hexstr.length()-2);
            int up = transStr2Num(string.substring(0,1));
            int down = transStr2Num(string.substring(1,2));
            result[length-1] = up*16+down;
        }
        return result;
    }

    public static int transStr2Num(String s){

        if (s.equals("a")){
            return 10;
        }
        if (s.equals("b")){
            return 11;
        }
        if (s.equals("c")){
            return 12;
        }
        if (s.equals("d")){
            return 13;
        }
        if (s.equals("e")){
            return 14;
        }
        if (s.equals("f")){
            return 15;
        }

        return Integer.parseInt(s);
    }





}
