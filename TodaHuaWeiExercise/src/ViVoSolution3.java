import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViVoSolution3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {
        if(input.length<1){
            return -1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < input.length; i++) {
            stringBuffer.append(input[i]);
        }
        String inputStr = stringBuffer.toString();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        String inpuStr2  = new String(inputStr);
        int res = 0;
        int k = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            if(!hashMap.keySet().contains(inputStr.charAt(i))){
                hashMap.put(Integer.valueOf(inputStr.charAt(i)),1);
            }else {
                hashMap.put(Integer.valueOf(inputStr.charAt(i)),hashMap.get(Integer.valueOf(inputStr.charAt(i))+1));
            }
        }
        for (Integer i:hashMap.keySet()) {
            res = res + hashMap.get(i)*hashMap.get(i);
        }
        return res;
/*        while (inpuStr2.length() > 0){
            for (int i=0 ; i < inputStr.length()-1; i++){
                if(inputStr.charAt(i) == inputStr.charAt(i+1)){
                    int j = i;

                }
            }
        }*/
    }

   /* private static int getOne(String s){

    }
    private static  String getone(String s){
        if(s.length()<1){
            return  s;
        }
        for (int i = 0; i < ; i++) {

        }
    }*/
}
