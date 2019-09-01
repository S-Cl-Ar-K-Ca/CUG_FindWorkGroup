import java.util.Arrays;
import java.util.Scanner;

public class ZiDianSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSize = scanner.nextInt();
        String []words = new String[inputSize];
        for (int i = 0; i < inputSize; i++) {
            words[i] = scanner.next();
        }
        Arrays.sort(words);
        for (String s: words) {
            System.out.println(s);
        }
    }

    public static int countOne(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
