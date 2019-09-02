import com.sun.deploy.util.SyncAccess;

import java.util.Scanner;

public class LongSplitSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            long input = scanner.nextLong();
            System.out.println(getResult(input));
        }
    }
    public static String getResult(long ulDataInput){
        StringBuffer stringBuffer = new StringBuffer();
        while (ulDataInput !=1 ){
            for (int i = 2; i <= ulDataInput; i++) {
                if(ulDataInput % i == 0 ){
                    stringBuffer.append(i).append(" ");
                    ulDataInput = ulDataInput/i;
                    break;//退出当前的for循环
                }
            }
        }
        return stringBuffer.toString();
    }
}
