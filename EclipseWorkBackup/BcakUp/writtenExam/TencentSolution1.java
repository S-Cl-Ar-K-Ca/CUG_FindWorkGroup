package writtenExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TencentSolution1 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input=scanner.next();
        System.out.println(dele01S(input));
        System.out.println(dele01S(input).length());
        System.out.println(math01(input));
        scanner.close();
    }
    
    public static boolean isOver( String string) {
        boolean flag=true;
        Map<Character, Integer> hmMap=new HashMap<>();
        for(int i=0;i< string.length();i++) {
            if (!hmMap.containsKey(string.charAt(i))) {
                hmMap.put(string.charAt(i), 1);
            }else {
                hmMap.put(string.charAt(i), hmMap.get(string.charAt(i))+1);
            }
        }
        if (hmMap.containsKey('0') && hmMap.containsKey('1')) {
            flag=false;
        }
        return flag;
    }
    
    public static String dele01S(String s) {
        if (s == "" || s == null)
            return s;
        if (isOver(s.replaceAll("01", "").replaceAll("10", ""))) {
            return s.replaceAll("01", "").replaceAll("10", "");
        }else {
            return dele01S(s.replaceAll("01", "").replaceAll("10", ""));
        }   
    }
    
    public static int math01(String string) {
        Map<Character, Integer> hmMap=new HashMap<>();
        for(int i=0;i< string.length();i++) {
            if (!hmMap.containsKey(string.charAt(i))) {
                hmMap.put(string.charAt(i), 1);
            }else {
                hmMap.put(string.charAt(i), hmMap.get(string.charAt(i))+1);
            }
        }
        int station =  ( hmMap.get('1') > hmMap.get('0') )?1:0; 
        if (station==1) {
            for (int i=0;i< hmMap.get('1')-hmMap.get('0');i++) { System.out.print("1"); }            
        }
        if (station==0) {
            for (int i=0;i< hmMap.get('0')-hmMap.get('1');i++) { System.out.print("0"); }            
        }
       return Math.max(hmMap.get('1'), hmMap.get('0'))-Math.min(hmMap.get('1'), hmMap.get('0'));
    }
}
