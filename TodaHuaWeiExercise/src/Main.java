import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        if(expr.length()<1){
            return expr;
        }
        if(!isHefa(expr)){
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (expr.contains("(")&&expr.contains(")")){
            String temp = reverse(expr.substring(expr.lastIndexOf("("),expr.indexOf(")")+1));
            expr = expr.replace(expr.substring(expr.lastIndexOf("("),expr.indexOf(")")+1),temp.substring(1,temp.length()-1));
        }
       return expr;
    }
    /******************************结束写代码******************************/

    static boolean isHefa(String s){
        if (s.length()<1){
            return false;
        }
        int leftcount = 0;
        int rightCount = 0;
        while (s.contains("(")){
            leftcount++;
            s = s.replace("(","");
        }
        while (s.contains(")")){
            rightCount++;
            s = s.replace(")","");
        }
        if(leftcount != rightCount){
            return false;
        }
        return true;
    }
    static boolean isHefa2(String s){
        if (s.length()<1){
            return false;
        }
        String regex = "\\(.*?\\)";
        s = s.replaceAll(regex,"");
        return isHefa(s);
    }
    static String reverse(String s){
        if (s.length()<1){
            return s;
        }
        StringBuffer ss = new StringBuffer(s);
        return ss.reverse().toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
