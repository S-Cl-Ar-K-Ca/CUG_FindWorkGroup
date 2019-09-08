import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XiaoMiSolution2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String input) {
        int pivot = input.indexOf(',');
        String subString1 = input.substring(0,pivot).replaceAll("\\(","*");
        String subString2 = input.substring(pivot,input.length());
        input = subString1+subString2;

        Stack<Character> stackForNode = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        char temp = '*';
        for (int i = 0; i < input.length()-1; i++) {
            if(Character.isDigit(input.charAt(i))){
                stackForNode.push(input.charAt(i));
            }else if(input.charAt(i) == ','){
                stringBuffer.append(stackForNode.pop());
            }else if(input.charAt(i) == '('||(input.charAt(i) == ')'&&input.charAt(i+1) == ')')){
                temp = stackForNode.pop();
                stringBuffer.append(stackForNode.pop());
                stackForNode.push(temp);
            }
        }
        while (!stackForNode.isEmpty()){
            stringBuffer.append(stackForNode.pop());
        }
        return stringBuffer.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
