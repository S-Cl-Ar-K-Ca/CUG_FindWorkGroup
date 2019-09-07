import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuaWeiSolution01 {
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
            stringBuffer.append(getResult(arr));
        }
        System.out.println(stringBuffer.toString());
    }

    public static int getResult(int arr[]){
        if( arr.length > 100){
            return  -1;
        }
        int res = Integer.MAX_VALUE;
        for(int i =1; i< arr.length/2;i++){
            int step = stepArrive(i,arr);
            if(step == -1){
                continue;
            }else {
                res = Math.min(res,step);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static int stepArrive(int i , int []arr){
        int res = 1;
        int stepArriveAt = i;

        while (stepArriveAt < arr.length-1){
            res++;
            stepArriveAt = stepArriveAt + arr[stepArriveAt];
        }
        return (stepArriveAt==arr.length-1)?res:-1;
    }

}
