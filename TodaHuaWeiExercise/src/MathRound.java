import java.util.Scanner;

public class MathRound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double input = scanner.nextDouble();
            System.out.println(Math.round(input));
        }
    }
}
