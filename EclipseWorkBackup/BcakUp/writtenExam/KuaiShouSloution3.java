package writtenExam;

import java.util.Scanner;

/**
 * @author hadoop
 *输出一个数的二进制数中，有多少个1
 */
public class KuaiShouSloution3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x =scanner.nextInt();
       System.out.println("递归方法的结果："+countNumof_1(Integer.toBinaryString(x), 0, Integer.toBinaryString(x).length()-1, 0));
       System.out.println("位运算的结果："+countNumof_1(x));
       scanner.close();
    }
    
    
    //使用递归的方法统计二进制字符串中有多少个1
    public static int countNumof_1(String s, int left,int right,int a) {
        int res =a;
        if (left >right) {
            return res;
        }else {
            if (s.charAt(left) == '1') {
                res++;
            }
            return countNumof_1(s, left+1, right,res);
        }
    }
    
    //使用位运算来统计一个数的二进制中有多少个1
    public static int countNumof_1(int k) {
        int res=0;
        if(k==0) {
            return 0;
        }
        while(k!=0) {
            res++;
            k= k & (k-1);
        }
        return res;
    }
}
