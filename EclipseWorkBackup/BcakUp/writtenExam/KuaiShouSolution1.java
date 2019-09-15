package writtenExam;

import java.util.Scanner;

/**
 * @author hadoop
 *输入一组数，形式大概为：12,10,15,12,13,15,11
 *判断其能否满足一颗二叉搜素数：man二叉树，假如中序遍历的话会是输出有序数组
 */
public class KuaiShouSolution1 {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        String s1 =scanner.next();
        if (s1.equals("None")) {
            System.out.println("True");
        }
        String string[] = s1.split(",");
        //先判断树的节点满不满足构成一颗满二叉树
        if (!checkMan(string.length+1)) {
            System.out.println("False");
        }else {
            int arr[]=new int [string.length];
            for (int i=0; i<arr.length;i++) {
                arr[i]=Integer.parseInt(string[i]);
            }
            if (checkShu(arr)) {
                System.out.println("True");
            }else {
                System.out.println("False");
            }
        }
        scanner.close();
    }
    //检查满二叉树的所有父节点满不满足大于左子树。小于右子树
    public static boolean checkShu(int arr[]) {
        boolean res=true;
        for(int i=0;i<=arr.length/2-1 && res; i++) {
            res=( (arr[i] >= arr[i*2+1]) && (arr[i] <= arr[i*2+2]))?true:false;
        }
        return res;
    }
    //檢查树的节点数是否满足满二叉树
    public static boolean checkMan(int k) {
        if (k<1) return false;
        int i=1;
        while(i <= k) {
            if (i == k) return true;
            i=i<<1; //左移一位，低位补0
        }
        return false;//K不是2的n次方
    }
}
