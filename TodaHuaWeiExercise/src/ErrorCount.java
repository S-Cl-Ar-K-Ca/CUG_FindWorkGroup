import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String messageLine = null;
        // 需要有序，循环读入，只读取最后8条
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        while ((messageLine = bufferedReader.readLine()) != null ) {
            if(!messageLine.contains(" ")){
                break;
            }
            String[] msgs = messageLine.split(" ");
            String msgFilename = msgs[0];
            String msgLocation = msgs[1];

            msgFilename = msgFilename.substring(msgFilename.lastIndexOf("\\") + 1);
            if (msgFilename.length() > 16) {
                msgFilename = msgFilename.substring(msgFilename.length() - 16);
            }

            String errorMsg = String.format("%1$s %2$s", msgFilename, msgLocation);
            if (!linkedHashMap.keySet().contains(errorMsg)) {
                linkedHashMap.put(errorMsg, 1);
            } else {
                linkedHashMap.put(errorMsg, linkedHashMap.get(errorMsg) + 1);
            }
        }
        int count = 0;
        for (String key : linkedHashMap.keySet()) {
            count++;
            if (count > linkedHashMap.keySet().size() - 8) {
                System.out.println(key + " " + linkedHashMap.get(key));
            }
        }
    }
}
