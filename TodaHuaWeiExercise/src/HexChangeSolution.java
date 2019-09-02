import java.util.Scanner;

public class HexChangeSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            System.out.println(Integer.parseInt(input.substring(2),16));
        }
    }
}
