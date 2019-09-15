package Findwork;
import java.util.Scanner;

/**
 * @author hadoop
 *采用动态规划  找到字符串1和字符串2 所具有的的最长公共子序列
 *https://blog.csdn.net/hrn1216/article/details/51534607
 */
public class LCSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1=new Scanner(System.in);
		String str1=s1.next();
		String str2=s1.next();
		
		System.out.println(getLPS(str1, str2));
		s1.close();

	}
	
	public static String getLPS(String str1,String str2) {
		StringBuffer sb =new StringBuffer();
		int xLen=str1.length();
		int yLen=str2.length();	
		int dp[][] = new int [str2.length()+1][str1.length()+1];
			
		//向二位数组中填充数字
		for(int i=1;i<=yLen;i++) 	{
			for (int j=1;j<xLen;j++) {
				if(str2.charAt(i-1)==str1.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);//当两者相同时，选取的是前者
				}
			}
		}//最后举证最右下角的数字就是最长公共子序列的长度
		
		//倒推出来最长公共子序列
		int i = yLen;
		int j = xLen;
		while(i>0 && j>0) 
		{
			if (str2.charAt(i-1)==str1.charAt(j-1)) {
				sb.append(str2.charAt(i-1));
				i--;
				j--;
			}else {
				if (dp[i-1][j]==dp[i][j-1]) {
					j--;
				}else if(dp[i-1][j]>dp[i][j-1]) {
					i--;
				}else if (dp[i-1][j]<dp[i][j-1]) {
					j--;
				}
			}
		}
		
		return sb.reverse().toString();  //最后需要反转一下才可以找到LPS
	}

}
