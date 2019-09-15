package Findwork;
/**
 * @author hadoop
最大子序列和
这里把最大子序列和放在第一个位置，它并不是字符串相关的问题，事实上它的目的是要找出由数组成的一维数组中和最大的连续子序列。
比如[0，-2，3，5，-1，2]应返回9，[-9，-2，-3，-5，-3]应返回-2。
 */
public class MaxSum {
		public static void main(String [] args) {
			int arr[]= {-5,-9,2,1,4,7,-5,8,3,-6};
			MaxSum m = new MaxSum();
			
			System.out.println(m.maxSum3(arr,0,arr.length-1));
			
			int res[] =m.maxSumIndex(arr);	
			for (int i : res) {
				System.out.println(i+" "); //循环输出数组内容的另一种做法
			}
			
			
		}
		
		public int maxSum(int arr[])   //只是找最长子序列和(属于动态规划方法)
		{
			//int res=0;
			int max_sum=-10000000;  //定义一个负数无穷小整数
			int sum = 0;  //子数字串之和
			
			for (int i=0;i<arr.length;i++) 
			{
				if(sum<0) 
				{
					sum = arr[i];  //子数字串之和小于0时，舍其现有子串列
				}else 
				{
					sum+=arr[i];
				}
				
				if (max_sum<sum) 
				{
					max_sum = sum;
				}
			}
			
			return max_sum;
		}
		
		public int [] maxSumIndex(int arr[])   //只是找最长子序列和, 并标记此串的头尾位置（线性动态规划方法）
		{
			//int res[] = new int[3];
			int start= 0;
			int curstart =0;
			int end =0;
			int max_sum=-1000000;
			int sum = 0;  //子数字串之和
			
			for (int i=0;i<arr.length;i++) 
			{
				if(sum<0) 
				{
					sum = arr[i];  //子数字串之和小于0时，舍其
					curstart=i;
				}else 
				{
					sum+=arr[i];
				}
				
				if (max_sum<sum)   //找到新的最大和
				{
					max_sum = sum;
					start =curstart;
					end =i;
				}
			}
			
			int res[] = {max_sum,start,end} ;
			return res;
		}

		public int maxSum3(int arr[],int left,int right)  //采用分治法  递归找出最大子串和(结果运行是对的，没太好理解到)
		{
			 if( left == right )  // Base case
			        if( arr[ left ] > 0 )
			            return arr[ left ];
			        else
			            return 0;
			    int center = ( left + right ) / 2;
			    int maxLeftSum  = maxSum3( arr, left, center );
			    int maxRightSum = maxSum3( arr, center + 1, right );
			    int maxLeftBorderSum = 0, leftBorderSum = 0;
			    for( int i = center; i >= left; i-- )
			    {
			        leftBorderSum += arr[ i ];
			        if( leftBorderSum > maxLeftBorderSum )
			            maxLeftBorderSum = leftBorderSum;
			    }
			    int maxRightBorderSum = 0, rightBorderSum = 0;
			    for( int j = center + 1; j <= right; j++ )
			    {
			        rightBorderSum += arr[ j ];
			        if( rightBorderSum > maxRightBorderSum )
			            maxRightBorderSum = rightBorderSum;
			    }
			    return MaxOf3( maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum );
		}
		
		public  int MaxOf3(int a,int b,int c) 
		{
			int res = (a>b)?a:b;
			if  (res<c)
				 res=c;
			
			return res;
		}
}
