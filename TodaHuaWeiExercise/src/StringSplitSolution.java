import java.util.Scanner;

public class StringSplitSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            stringSplit(s1);
            stringSplit(s2);
        }
    }

    public  static void stringSplit(String input){
        if(null == input){
            return;
        }
        if(input.length()%8 != 0){
            input = input + "00000000";
        }
        while (input.length()>=8){
            System.out.println(input.substring(0,8));
            input = input.substring(8);
        }
        return;
    }
}
