import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QiShuiPingSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        StringBuffer stringBuffer = new StringBuffer();
        while ((string = bufferedReader.readLine()) != null && !string.equals("")) {
            if(string.equals("0")){
                break;
            }
            stringBuffer.append(Integer.valueOf(string)/2).append("\n");
        }
        System.out.print(stringBuffer.toString());
    }
}
