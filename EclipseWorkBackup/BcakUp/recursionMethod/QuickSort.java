package recursionMethod;


public class QuickSort {
    public static void main(String[] args) {
        int test[]= {20,-9,8,1,-34,45,10,6,2,40};
        quickSort(test, 0, test.length-1);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]+" ");
        }
    }
    
    //partition函数的使用范围很广
    public static int partition(int arr[],int left, int right) {
        int pivot =arr[left];
        int pivotIndex = left;
        while (left< right) {
            while (left < right && arr[right]>=pivot)
                right--;
            arr[left]=arr[right];
            while(left < right && arr[left] < pivot)
                left++;
            arr[right]=arr[left];
        }
        arr[left]=pivot;
        pivotIndex =left;
        return pivotIndex;
    }  
    //使用递归进行快速排序
    public static void quickSort(int arr[],int left,int right) {
        if (left>right) {
            return;
        }
        int mid=partition(arr, left, right);
        quickSort(arr, left, mid-1);
        quickSort(arr, mid+1, right);
    }
}
