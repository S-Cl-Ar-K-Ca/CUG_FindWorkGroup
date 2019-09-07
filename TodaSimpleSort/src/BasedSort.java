public class BasedSort {
    /**
     * @author hadoop
     * 冒泡排序 + 选择排序 + 插入排序
     * 参考博客：https://blog.csdn.net/weixin_40205234/article/details/86699088
     */
    public static void bubbleSort(int arr[]){
        for(int i = 0; i < arr.length-1;i++){
            for(int j=arr.length-1; j > i;j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
