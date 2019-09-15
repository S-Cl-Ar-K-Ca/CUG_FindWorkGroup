import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ViVoSolution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );
        System.out.println(output);
    }

    private static int solution(String str) {
        if(null == str || str.equals("")){
            return -1;
        }
        int index = str.lastIndexOf("0");
        String substr = str.substring(index);
        int res=0;
        int zuoCount=0;
        while (substr.contains("(")){
            substr = substr.replaceAll("\\(","");
            zuoCount++;
        }
        for(int i=0;i < substr.length();i++){
            res = (substr.charAt(i)==')')?res+1:res;
        }
        return res-zuoCount;
    }
}
