package Findwork;
import java.util.Scanner;

/**
 * @author hadoop
 *  利用两种方法实现字符串 的 反转
 */
public class reverseStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String string=s.next();
		System.out.println(reverseStr3(string));
		s.close();

	}
	
	//  方法一  使用字符串和字符数组之间的相互转换  实现字符串的反转
	public static  String ReverStr(String str1) {

		char chArr[]=str1.toCharArray();
		char temp;
		for (int i=0;i<str1.length()/2;i++) 	{
			temp =chArr[i];
			chArr[i] = chArr[str1.length()-1-i];
			chArr[str1.length()-1-i]=temp;
		}
		return String.valueOf(chArr); // 将字符串转为为string  需要用String.valueof(char []),而不能够用char.toString函数
	}
	
	//方法二 ：使用递归和 substring 两个知识点实现字符串的反转
	public static  String ReverStr2(String str) {
		if(str.equals("") || str == null) {
			return str;
		}
		return str.charAt(str.length()-1)+ReverStr2( str.substring(0,str.length()-1) );
	}
	
	//方法三：使用stringbuffer自带函数即可实现翻转
	public static String reverseStr3(String str) {
		StringBuffer sBuffer=new StringBuffer(str);
		String res = sBuffer.reverse().toString();
		return res;
	}

}

