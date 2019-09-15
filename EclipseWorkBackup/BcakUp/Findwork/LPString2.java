package Findwork;
import java.util.Scanner;

/**
 * @author hadoop
 *利用中心法寻找最长回文子串  其中循环的时候分为“单核”和“双核”   string=findP(str, i, i);   string=findP(str, i, i+1);
 */
public class LPString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please input string for test LPS ：");
		Scanner s=new Scanner(System.in);
		String string=s.next();
		String res= LPS(string);
		System.out.println(res);
		s.close();
	}
	
	//中心法找回文字符串
	public static String findP(String str,int left, int right) {
		while (left >=0 && right<=str.length()-1&& str.charAt(left)==str.charAt(right)) 
		{
			left--;
			right++;
		}
		return str.substring(left+1, right); //左闭右开区间
	}
	
	public static String LPS(String str) {
		if (str.length()<=1) return str;
		
		String res="";
		String string;
		for(int i=0;i<str.length()-1;i++) 
		{
			string=findP(str, i, i);
			if (res.length()<string.length()) {
				res = string;
			}
			string=findP(str, i, i+1);
			if (res.length()<string.length()) {
				res = string;
			}
		}
		return res;
	}
}
