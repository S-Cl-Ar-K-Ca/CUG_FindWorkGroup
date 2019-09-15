package Findwork;
/**
 * @author hadoop
 *找出10亿个数中最大的1000个
 */
public class TopN {
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
	//构造小顶堆 放1000个元素  再读剩下的
	public static void buildMinHeap(int arr[]) {
		for(int i= arr.length/2-1 ; i>=0; i--) {
			MinHeapAdjust(arr, i, arr.length-1);
		}
	}
	public static void MinHeapAdjust(int arr[], int start, int end) {
		int parent=start;
		int pos = parent*2+1;
		
		for( ; pos<=end; parent=pos,pos=parent*2+1) {
			int temp = arr[parent];
			if (pos< end && arr[pos]>arr[pos+1]) {
				pos++;
			}if (temp<=arr[pos]) {
				break;
			}else {
				arr[parent]=arr[pos];
				arr[pos]=temp;
			}
		}		
	}
}
