package Findwork;

import java.util.Scanner;

/**
 * @author hadoop
 * 最长回文字符串的问题 Longest palindrome string （LPS）
 * 将字符串s1 进行翻转成 s2 然后寻找s2和s1的最长公共子串LCS
 * 
 *输入123321125775165561时，存在问题，应该存在两个最长回文字符串，但是我们写的这个只能输出后面.(可以确保最长，不能确保唯一性)
 *Please input string for test LPS ：123321125775165561123321
   结果是1233211，也存在一些问题

 */
public class LPString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please input string for test LPS ：");
		Scanner s=new Scanner(System.in);
		String string=s.next();
		String res= LPS(string);//得到右边的最长回文子串
	
/*		//判断其是否唯一
		if (res.length() >LPS(deleteSubString(string, res)).length()) {
			System.out.println(res);
		}else {
			System.out.println(LPS(deleteSubString(string, res)));
			System.out.println(res);
		}*/
		System.out.println(res);
		s.close();

	}	
	
	
	//找到最右边的最长回文字符串
	public static String LPS(String str) {
		return LCS(str, reverseString(str));
	}
	
	//使用递归和 substring 两个知识点实现字符串的反转
	public static String  reverseString(String str) {
		if (str==null || str.equals("")) {
			return str;
		}
		return str.charAt(str.length()-1)+reverseString(str.substring(0,str.length()-1));
	}
	
	//寻找最右边的  最长公共子串
	public static String LCS(String str1, String str2)
	{	
		//判断两个字符串是否为空
		if(str1==null || str2 == null) 
		{		return null;   }
		if (str1.equals(" ") || str2.equals(" ")) 
		{  return null;	 }
		int xLen = str1.length();   // 将s1放在x轴方向 ，其串长度为列数clo，xlen
		int yLen = str2.length();  // 将s2放在y轴方向 ，其串长度为行数row，ylen
		int baseCow[]=new int [xLen];    //记录基础行
		int curCow[] = new  int [xLen];   //记录当前行
		int maxLen =0;                               //记录最长子串长度，及当前矩阵中最大元素
		int pos=0;                                       //记录当前行最大元素的最大列数
		char c=' ';
		
		for (int i=0;i<yLen;i++) //遍历s2 ,Y 列方向
		{
			c =str2.charAt(i);
			for(int j=0;j<xLen;j++)     //比较S1，X行方向
			{
				if (c==str1.charAt(j)) 
				{
					//j为0时  第一列 没有左上角元素
					if (j==0) {
						curCow[j]=1;
					}else {
						//curCow[j]=curCow[j-1]+1; //这一句写错了
							curCow[j]=baseCow[j-1]+1;
						}	
					if (maxLen<curCow[j]) {
						 maxLen=curCow[j];
						pos =j;
					}
				}	
			}	
			//每当s2中一个元素 比较完一次s1时 生成一个curRow  , 将其赋给baseRow，然后清空
			for (int k=0;k<xLen;k++) 
			{
				baseCow[k]=curCow[k];
				curCow[k]=0;
			}
		}		
		return str1.substring(pos+1-maxLen, pos+1);  //substring c++和java 不同，java右边参数不包括， 记住这里找的是s1 , curRow找的是行
	}

	//删除指定子串
	public static String deleteSubString(String str1,String str2) {
		StringBuffer sb = new StringBuffer(str1);
		String res;
		int delCount = 0;
//		Object[] obj = new Object[2];
		while (true) {
			int index = sb.indexOf(str2);
			if(index == -1) {
				break;
			}
			sb.delete(index, index+str2.length());
			delCount++;		
		}
		if(delCount!=0) {
			res = sb.toString();
//			obj[1] = delCount;
		}else {
			//不存在返回-1
			res = str1;
//			obj[1] = -1;
		}	
		return res;
	}

}
