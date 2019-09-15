package Findwork;

import java.util.Scanner;

public class judge2N {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println("judge1 的判断结果"+judge1(n));
            System.out.println("judge2 的判断结果"+judge2(n));
            System.out.println("judge3 的判断结果"+judge3(n));
            System.out.println("====================");
        }
        scanner.close();
    }
    
    //将数n与自己减1后左移一位的数字  相与 ；若等于n-1, 则数n为2的n次方
    public static boolean judge1(int n) {
        if (n<1) return false;
        if (n==1) return true;
        if (n>1 && ( n & ((n-1)<<1) )==n) {
            return true;
        }
        return false;
    }
    //如果这个数n 的二进制串中 有且仅有1个“1”，则其为2的n次方
    public static boolean judge2(int n) {
        if (n<1) return false;
        int countOfOne=0;
        while (n!=0) {
            countOfOne++;
            n=n&(n-1);
        }
        return countOfOne>1?false:true;
    }
    //n 和 n-1 相与操作，假如结果为0 则n为2的某次方数
    public static boolean judge3(int n) {
        if (n<1) return false;
        return (n & (n-1))==0?true:false;
    }
}
