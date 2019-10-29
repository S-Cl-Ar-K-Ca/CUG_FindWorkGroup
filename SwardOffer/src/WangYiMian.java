public class WangYiMian {
    public static void main(String[] args) {
        int arr[] = {2,435,3,8,7,8,9};
        arr = solution01(arr);
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }
    public  static int  partition(int arr[] ,int left ,int right){
        int pivot = arr[left];
        int pivotIndex = left;

        while(left < right){
            while (left < right && arr[left] <= pivot )
                left++;
            arr[right] = arr [left];
            while (left < right && arr[right] > pivot)
                right--;
            arr[left] = arr[right];
        }
        arr[left] = pivot;
        pivotIndex = left;

        return pivotIndex;
    }

    public static void quickSort(int arr[],int left,int right){
        if(left >= right){
            return;
        }
        int mid = partition(arr,left,right);
        quickSort(arr,left,mid);
        quickSort(arr,mid+1,right);
    }

    //将数组中的奇数全部移动到左边   偶数全部移动到右边   且需要保持奇数之间相对顺序不变    偶数之间的相对顺序不变
    public static int[] solution01(int arr[]){
        int[] res = new int[arr.length];
        int left = 0;
        int right = arr.length-1;
        for(int i = 0;i < arr.length; i++){
            if( (arr[i] & 1) == 1){//如果是奇数
                res[left] = arr[i];
                left++;
            }
            if( (arr[arr.length-1-i] & 1) == 0 ){
                res[right] = arr[arr.length-1-i];
                right--;
            }
        }
        return res;
    }

    //将数组中的奇数全部移动到左边   偶数全部移动到右边   且不需要保持奇数之间相对顺序不变    偶数之间的相对顺序不变 ，可以模仿partition函数来做
    public static int[] solution(int arr[],int left,int right){
        int temp = arr[left];
        while (left < right){
            while (left < right && (arr[right] & 1) == 0)
                right--;
            arr[left] = arr[right];
            while (left < right && (arr[left] & 1) == 1)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = temp;

        return arr;
    }
}
