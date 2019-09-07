import java.util.Scanner;

public class HuaWeiSolution03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(nchoosek(n,m)*getCount(m)%1000000007);

    }
    public static long nchoosek(long n, long k){
        if(n < 0 || k > n){
            return -1;
        }
        k = (k > (n - k)) ? n - k : k;  // C(n, k) = C(n, n - k)
        if(k <= 1){  // C(n, 0) = 1, C(n, 1) = n
            return k == 0 ? 1 : n;
        }
        long divisor = n - k + 1;
        long dividend = 1;
        double cnk = 1.0;
        for(long i = 0; i < n; i++){
            cnk *= (double) (divisor + i) / (dividend + i);
        }
        return (long) cnk;
    }

    public static long getCount(int m){
        //找规律 f(n) = n! + (n-1)2
/*
        if(m == 1){
            return 1;
        }else if(m == 2){ return 3;}
        else if(m == 3){return 10;}
*/

        long res = 1;
        long count = m;
        while (count > 0){
            res = res * count;
            count--;
        }
        return res+(m-1)*(m-1);
    }
}
