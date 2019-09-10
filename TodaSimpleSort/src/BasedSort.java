public class BasedSort {
    /**
     * @author hadoop
     * 冒泡排序 + 选择排序 + 插入排序
     * 参考博客：https://blog.csdn.net/weixin_40205234/article/details/86699088
     */
    public static void bubbleSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for(int j = arr.length-1; j > i; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }

        }
    }

    public static void selectSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            int k = i;
            for(int j = i+1; j < arr.length ;j++){
                if(arr[k] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                }
            }
        }
    }

    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int pivot = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > pivot ){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = pivot;
        }
    }

    public static void quickSort(int arr[],int left ,int right){
        if(left >= right){
            return;
        }
        int mid = partition(arr,left,right);
        quickSort(arr,left,mid);
        quickSort(arr,mid+1,right);
    }
    public static int partition(int arr[],int left ,int right){
        int pivot = arr[left];
        int pivotIndex = left;
        while (left < right){
            while (left <right && arr[right] >= pivot)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] < pivot)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        pivotIndex = left;
        return pivot;
    }
}

/**
 * @author hadoop
 * 冒泡排序 + 选择排序 + 插入排序
 * 参考博客：https://blog.csdn.net/weixin_40205234/article/details/86699088
 */
 class baseSort {
    public static void main(String args[]) {
        int arr[]= {8,3,56,3,-2,9,-18};
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        //bubbleSort(arr);
        //slectSort(arr);
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    //冒泡排序的一种写法，小的数字向前冒泡，两两比较两两交换
    public static void bubbleSort(int arr[]) {
        int temp;
        for (int i=0;i<arr.length-1;i++) {
            for(int j = arr.length-1;j>i;j--) {
                if (arr[j]<arr[j-1]) {
                    temp =arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    //选择排序  选择最小的放到前面来
    //i代表轮数，j在遍历i后面数组元素，k开始指向i(以k所指数作为基础，不断和j指向数比较或交换，使k指向处的数最小)
    public static void slectSort (int arr[]) {
        int temp;
        for (int i=0;i<arr.length-1;i++) {
            int k=i;
            for(int j=i+1;j<=arr.length-1;j++) {
                if (arr[k]>arr[j]) {
                    temp =arr[j];
                    arr[j]=arr[k];
                    arr[k]=temp;
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int arr[]) {
        for (int i=1;i<= arr.length-1;i++) {
            int pivot= arr[i];
            int j=i;
            while(j>0 && arr[j-1]>pivot) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j]=pivot;  //pivot 查到了其合适的位置
        }
    }

}