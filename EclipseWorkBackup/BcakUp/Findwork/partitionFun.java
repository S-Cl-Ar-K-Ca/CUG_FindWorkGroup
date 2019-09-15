package Findwork;

/**
 * @author hadoop
 * 学习partition函数的用图  用来实现一下快速排序
 * 存在问题（1）partition函数的swap函数调用的时候，传入下标即可。算法思想是没有问题的。
 * （2）partition2没有问题，quickSort函数的递归条件需要进行修改
 * 
 * 针对上述问题,重新编写partitionFun_2来完善。
 */
public class partitionFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr1[]= {5,9,2,1,4,7,5,8,3,6};
		partitionFun p=new partitionFun();
//		System.out.println(arr1.length);
		
		int res=p.partition2(arr1, 0, arr1.length-1);
		System.out.println(res);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		 
		System.out.println();
		p.quickSort(arr1, 0, arr1.length-1);
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		 

	}
	
	public int partition(int arr[],int left ,int right) 
	{
		int pivot = arr[left];//设置为数组第一个量，也可以是随机的
		int pivotIndex = left;//第一个指针，找pivot最终的索引
		
		for(int i=left+1;i<=right;i++) 
		{
			if (arr[i]<=pivot) 
			{
				pivotIndex++;
				swap(arr,arr[i], arr[pivotIndex]);
			}
		}
		
		swap(arr,arr[pivotIndex], arr[left]);
		
		return pivotIndex;
	}
	
	public int partition2(int arr[],int left,int right) //用双指针来互换，http://blog.jobbole.com/105219/
	{
		int pivot = arr[left]; //现将数组第一个元素作为“轴”标准，保留下来
		
		while(left<right) 
		{
			while(left<right && arr[right]>=pivot)
				right--;
			arr[left]=arr[right];
			
			while(left<right && arr[left]<=pivot)
				left++;
			arr[right]=arr[left];
		}
		
		arr[left]=pivot;//此时left和right指在同一位置，此处该是pivotIndex的位置，将其赋值为pivot
		return left;

	}
	
	public void quickSort(int arr[],int left,int right)  //利用partition函数实现快排
	{
		if (left>=right-1) {
       			return;
		}
		
		int mid=partition(arr, left, right);
		
		//两边进行递归partition
		quickSort(arr, left, mid-1);
    	quickSort(arr, mid+1, right);
	
	}
	
public static void swap(int a,int b) //两个数交换  注意这个用不了，java不能对原始数据互换
	{
		int c=a;
		a=b;
		b=c;
	}
	
	void swap(int arr[],int a,int b)//两个数组变量交换
	{
		int c=arr[a];
		arr[a]=arr[b];
		arr[b]=c;
	}

}
