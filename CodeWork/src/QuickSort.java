public class QuickSort {
    public static void main(String[] args) {
        int arr[]={1,234,3,74,-122,0,23,3,-3};
        System.out.print("begin");
        quickSortFun(arr,0,arr.length-1);
        for (int i:arr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void quickSortFun(int []arr,int left, int right){
        if (left >= right){
            return;
        }
        int mid = partition(arr,left,right);
        quickSortFun(arr,left,mid);
        quickSortFun(arr,mid+1,right);
    }

    public  static int partition(int []arr,int left,int right){
        int pivot = arr[left];
        int pivotIndex = left;
        while (left < right){
            while(left < right && arr[right] >= pivot)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] < pivot)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        pivotIndex = left;
        return  pivotIndex;
    }

}
