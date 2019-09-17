/*
* 斐波拉契数列的两种写法
* */
public class Ex09 {
    public static long Fibonacci(int a){
        if(a <= 0){
            return 0;
        }
        if(a == 1){
            return 1;
        }

        return Fibonacci(a-2)+Fibonacci(a-1);
    }

    public static long FibonacciV2(int a){
        long res[] = {0,1};
        if(a<2){
            return res[a];
        }
        long a0 = 0;
        long a1 = 1;
        long a2 = 0;
        for (int i = 2; i <= a ; i++) {
            a2 = a0 + a1;
            a0 = a1;
            a1 = a2;
        }
        return a2;
    }
}
