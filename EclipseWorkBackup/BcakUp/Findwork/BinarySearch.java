package Findwork;

import java.util.HashMap;

public class BinarySearch {
    public static void main(String[] args) {
      /*  Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(getLofLNPS(s));
        scanner.close();*/
        int arr[]= {23,-34,3,6,78,3,5,37,22,-3,2,0};   
        System.out.print("Before Sort：");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        QuickSort(arr, 0, arr.length-1);
        System.out.println();
        System.out.print("After Sort：");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("二分查找得Index为："+ErfenFind(arr, 0, arr.length-1, 79));
        
    }
    public static int getLofLNPS( String  s) {
        HashMap< Character, Integer> hMap= new HashMap<>();
        int i=0,pos=0,res=0;
        for (; i<s.length(); i++) {
            if (hMap.containsKey(s.charAt(i))) {
                pos = Math.max(hMap.get(s.charAt(i)), pos);
            }
            res = Math.max(res, i-pos+1);
            hMap.put(s.charAt(i), i+1);
        }
        return res;
    }
    
    public static  int partition(int arr[],int left,int right) {
        int pivot = arr[left];
        int pivotIndex=left;
        while(left<right) {
            while(left < right && arr[right]>=pivot) 
                right--;
            arr[left] =arr[right];
            while (left < right && arr[left]<pivot)
                left++;
            arr[right]=arr[left];
        }
        pivotIndex = left;
        arr[pivotIndex] = pivot;
        return pivotIndex;
    }
    
    public static  void QuickSort(int arr[],int left,int right) {
        if (left>right) {
            return ;
        }
        int mid= partition(arr, left, right);
        
        QuickSort(arr, left, mid-1);
        QuickSort(arr, mid+1, right);
    }
    
    //写一个对有序数组的二分查找
    public static  int ErfenFind(int arr[],int left,int right,int k) {
        while(left<=right) {
            if (k == arr[(left+right)/2]) {
                return (left+right)/2;
            }
            else if (k < arr[(left+right)/2]) {
                return ErfenFind(arr, left, (left+right)/2-1, k);
            }else {
                return ErfenFind(arr, (left+right)/2+1,right, k);
            }
        }
         return -1;//表示没有找到   
    }
    
    public static int Countof(int n) {
        int count =0;
        if (n==0) {
            return 0;
        }
        while(n!=0) {
           count++;
           n=n&(n-1);
        }
        return count;
    }
}
