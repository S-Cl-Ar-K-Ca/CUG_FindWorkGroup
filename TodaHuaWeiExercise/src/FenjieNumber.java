import java.util.ArrayList;
import java.util.Scanner;

public class FenjieNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        for(Integer i: getResult(input)){
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> getResult(int a){
        ArrayList<Integer> res = new ArrayList();
        while (a>1){
            for(int i=2;i <= a ;i++){
                if(a%i == 0){
                    res.add(i);
                    a = a/i;
                    break;
                }
            }
        }
        return  res;
    }
}
