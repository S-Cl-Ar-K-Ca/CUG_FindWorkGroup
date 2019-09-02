import java.util.ArrayList;
import java.util.Scanner;

public class QiShuiSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs =new ArrayList<Integer>();
        boolean exit = false;
        while (!exit){
            int in = scanner.nextInt();
            inputs.add(in);
            if (in == 0){
                exit = true;
                inputs.remove(inputs.size()-1);
            }
        }
        for (Integer i:inputs) {
            System.out.println(getResult03(i));
        }
    }

    public static int getResult(int a){
        int res = 0;
        if(a <= 1){
            return res;
        }else {
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0 ;i < a; i++){
                stringBuffer.append("1");
            }
            String s = stringBuffer.toString();
            while (s.contains("111")){
                res++;
                s = s.replaceFirst("111","1");
            }
            if("11".equals(s)){
                res++;
            }
        }
        return res;
    }

    public static int getResult02(int a){
        int res = 0;
        if(a <=1 ) { return res; }
        else if(a == 2){return 1;}
        else {
            while( a>=3 ){
                int x = a/3;
                res = res + x;
                int y = a%3;
                a = x + y;
            }
            if(a==2){
                res++;
            }
        }
        return res;
    }

    public static int getResult03(int a) {
        int res = a / 2;
        return res;
    }
}
