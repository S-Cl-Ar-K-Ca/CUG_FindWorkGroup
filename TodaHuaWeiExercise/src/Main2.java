import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        StringBuffer stringBuffer = new StringBuffer();
        while ((input=bufferedReader.readLine())!=null && !input.equals("")){
            stringBuffer.append(input).append("*");
        }
        String[] inputs = stringBuffer.toString().split("\\*");
        int pivot = Integer.valueOf(inputs[0]);
        input = inputs[1];
        String[] strings = input.split(" ");
        StringBuffer sRight = new StringBuffer();
        StringBuffer sLeft = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            if(Integer.valueOf(strings[i]) > pivot){
                sRight.append(strings[i]).append(" ");
            }else {
                sLeft.append(strings[i]).append(" ");
            }
        }
        String res = sLeft.append(sRight.toString()).toString().trim().replaceAll(" ",",");
        System.out.println(res);
    }
}
