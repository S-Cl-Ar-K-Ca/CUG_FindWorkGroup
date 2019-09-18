/*使用递归实现二分查找*/
public class BinarySearch {
    public static int binarySearch(int arr[],int key,int left,int right){
        if(key < arr[left] || key > arr[right] || left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if(key == arr[mid]){
            return mid;
        }else if(key < arr[mid]){
            return binarySearch(arr,key,left,mid-1);
        }else {
            return binarySearch(arr,key,mid+1,right);
        }
    }
}
