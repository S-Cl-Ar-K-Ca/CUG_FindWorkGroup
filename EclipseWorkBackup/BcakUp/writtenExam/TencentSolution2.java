package writtenExam;

import java.util.Arrays;
import java.util.Scanner;

public class TencentSolution2 {
    
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int  m= scanner.nextInt();
        int n = scanner.nextInt();
        int arr[]=new int [n];
        for (int i =0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        //quickSort(arr, 0, arr.length-1); 验证有效
       System.out.println(LestCion(m, arr));
       scanner.close();
    }
    
    public static int LestCion(int m,int coins[]) {
        if (m<=0) return -1;
        if (coins[0] !=1 ) return -1;
        int currentCoinSum=0;int i=0;int res=0;
        
        while(currentCoinSum < m) {
            for (;i<coins.length;i++) {
              //新加入得coin面值最好<=当前有的所有硬币面值纸盒currentCoinSum，并且是最大面值
                //这里coin是是按照面值升序排好序的。假如大于currentCoinSum+1
                if (coins[i] > currentCoinSum+1)
                    break;
            }
            currentCoinSum=currentCoinSum+coins[i-1];   
            res++;
        }
        return res;
    }
    
    
   //对数组进行快速排序
    public static void quickSort(int arr[],int left,int right) {
        if (left>=right)
            return;
        int mid=partition(arr, left, right);
        quickSort(arr, left, mid-1);
        quickSort(arr, mid+1, right);
    }
    
    public static int partition(int arr[],int left ,int right) {
        int pivot=arr[left];
        int pivotIndex = left;
        while(left<right) {
            while(left<right && arr[right]>=pivot)
                right--;
            arr[left] = arr[right];
            while(left<right && arr[left]<pivot)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        pivotIndex = left;
        return pivotIndex;
    }
}
