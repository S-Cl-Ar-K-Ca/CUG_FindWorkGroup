package Findwork;
/**
 * @author hadoop
 * Longest Common Substring
 *最长公共子串（LCS）问题  通过用s1和s2构建矩阵的方法来做

 */
public class LCSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="baba";
		String s2="caba";
		String res =LCS(s1, s2);
		System.out.println(res);
	}
	
	//超找连个子串中的最长公共子串
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

}
