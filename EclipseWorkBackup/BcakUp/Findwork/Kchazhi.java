package Findwork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class Kchazhi {

	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int length=s1.nextInt();
		int arr[]=new int [length];
		int k= s1.nextInt();
		
		for (int i=0;i<length;i++) {
			arr[i]=s1.nextInt();
		}
		
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		printK(arr, k);
		s1.close();
		
		/*int arr[]= {0,1,2,3,4,5,6,7,8,9};
		printK(arr, 4);*/
	}
	
	public static  void printK(int arr[],int k) {
		int count=1;
		HashMap<Integer,Integer> hm = new HashMap<>();
		//把数放进hashMap
		for(int i=0; i<arr.length;i++) {
			if (!hm.containsKey( arr[i] )) {
				hm.put(arr[i], 1);
			}else {				
				count++;
				hm.put(arr[i], count);
				
			}
		}
		//检查hashSet的元素是整数是，是不是有序的  //整数时，输出数有序的
			for (Iterator<Integer> i3 = hm.keySet().iterator(); i3.hasNext();) {
				Integer integer = (Integer) i3.next();
				System.out.print(integer+" ");
			}
			System.out.println();
			Iterator<Integer> i1=hm.keySet().iterator();
			int res=0;
			while(i1.hasNext()) {
				int index =(Integer)i1.next();
				if (hm.containsKey(index+k)) {
					//输出差值为K的数对
					System.out.print(index+" "+(index+k));
					System.out.println();
					res++;  //统计去重之后的K差数值的条目数
				}
			}
			System.out.println(res);
			
		}
		
}


