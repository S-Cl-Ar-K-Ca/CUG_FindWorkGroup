package Findwork;

/**
 * @author hadoop
 *针对的是版本1中出现的一些问题，现在进行完善；
 *
 */
public class partitionFun_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[]= {5,9,2,1,4,7,5,8,3,6};
		partitionFun_2  p = new partitionFun_2();
		
		int arr[]=p.randomArr(50, 100);
		
/*		int res = p.partition(arr, 0, arr.length-1);
		
		System.out.println(res);*/
		
		for(int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+ " ");
		}
		
		p.quickSort(arr, 0, arr.length-1);
		System.out.println();
		for(int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+ " ");
		}
	}
	
	public int partition(int arr[],int left ,int right)  //采用指针进行比较
	{
		int pivot = arr[left];			
		int pivotIndex = left;
		
		for(int i=left +1;i<=right;i++) 
		{
			if(arr[i]<=pivot) 
			{
				pivotIndex++;
				swap(arr,pivotIndex,i);
			}
		}
		
		swap(arr, left, pivotIndex);
		return  pivotIndex;
		
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
	
	//分别可以使用上面两种partition函数实现快排，快排递归条件要控制好
	public void quickSort(int arr[],int left ,int right) 
	{
		if (left>=right)//递归终止的条件 
		{
			return;
		}	
		int mid = partition2(arr, left, right);	
		quickSort(arr, left, mid);
		quickSort(arr, mid+1, right);
		
	}
	
	//假如不调用partition 函数   直接写出快排
	public void quickSort2(int arr[],int left ,int right) 
	{
		if (left>=right) 
		{
			return ;
		}
		
		int pivot =arr[left];
		int pivotIndex = left;
		
		for (int i =left +1;i<=right;i++) 
		{
			if (arr[i]<=pivot) 
			{
				pivotIndex++;
				swap(arr, pivotIndex, i);
			}
		}
		
		swap(arr, pivotIndex, left);
		
		quickSort2(arr, left, pivotIndex);
		quickSort2(arr, pivotIndex+1, right);
		
		
	}
	
	public void swap(int arr[],int a ,int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	//生成随机数 数组  siz2数组大小 max数以内的值
	public int[] randomArr(int size,int max)
	{
		int arr[] =new int [size];
		
		for (int i=0;i<arr.length;i++) 
		{
			arr[i] = (int)(Math.random()*10000%max); //random函数是随机0到1之间的随机数
		}
		
		return arr;
	}
	

}
