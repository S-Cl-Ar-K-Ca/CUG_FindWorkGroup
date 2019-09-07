import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuaWeiSolution02 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null ;
        StringBuffer stringBuffer = new StringBuffer();
        while ((input = bufferedReader.readLine())!=null && !input.equals("")){
            String []inputs = input.trim().split(" ");
            int []arr = new int[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.valueOf(inputs[i]);
            }
            stringBuffer.append(getMinStep(arr));
        }
        System.out.println(stringBuffer.toString());
    }

    public static int getMinStep(int[] value){

        int minStep = Integer.MAX_VALUE;
        int maxFirstStep = value.length/2;
        for (int i=1;i<maxFirstStep;i++){
            int step = step2Tai(i,value);
            if (step==-1){
                continue;
            }else{
                if (step<=minStep){
                    minStep = step;
                }
            }
        }
        if (minStep==Integer.MAX_VALUE){
            return -1;
        }else{
            return minStep;
        }

    }

    public static int step2Tai(int firstStep, int[] value){
        int stepNum = 0;
        int i = firstStep;
        while (i<value.length-1){
            i = i + value[i];
            stepNum++;
        }
        if (i==(value.length-1)){
            return ++stepNum;
        }
        return -1;

    }

}