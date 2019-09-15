package Findwork;

/**
 * @author hadoop
 关于partition函数的应用  用来查找一个数组中第K大和第K小的数字；
 其中找第K小的数据比较直观，即找进行排序后的index为K-1的数字    （其实这里没有排序  可以再体会一下）
 找K大的数据，则需要做出相应的调整，找索引为Index是arr.length-k的项即可
 */
public class KthSmallNumPart {

	public static void main(String[] args) {
		int arr[]= {5,9,2,1,4,7,5,8,3,6};
		
		KthSmallNumPart k =new KthSmallNumPart();
		
		System.out.println(k.KthBig(arr, 5));
		System.out.println(k.Kthsmall(arr,2));
	}
	
	public int Kthsmall(int arr[],int k)
	{
		int left =0;
		int right = arr.length-1;
		int res=0;	
		
		while (left < right)
		{
			int index =partition2(arr, left, right);
			
			if (index == k-1) 
			{
				res = arr[index];
				break;
			}
			if (index > k-1) 
			{
				right = index;
			}else {
				left =index+1;
			}
		}
		
		return res;
	}
	
	public int KthBig(int arr[],int k)
	{
		int left =0;
		int right = arr.length-1;
		int res=0;	
		
		while (left < right)
		{
			int index =partition2(arr, left, right);
			
			if (index ==arr.length-k) 
			{
				res = arr[index];
				break;
			}
			if (index<arr.length-k ) 
			{
				left = index+1;
			}else {
				right=index;
			}
		}
		
		return res;
	}
	public int  partition2(int arr[],int left ,int right) //采用两个指针在寻找
	{
		int pivot =  arr[left];
		int pivotIndex = left;
		
		while(left<right) 
		{
			while(left<right && arr[right]>=pivot)
				right--;
				arr[left] = arr[right];
			while(left<right && arr[left]<pivot)
				left++;
				arr[right] = arr[left];
		}
		 arr[left] = pivot;
		 pivotIndex =left;
		 
		 return pivotIndex;
	}
}
