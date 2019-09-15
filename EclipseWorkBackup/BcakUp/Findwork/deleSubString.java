package Findwork;
/**
 * @author hadoop
 * 实现删除指定子串
 * 需要注意的是Stringbuffer和String的区别，参考博客https://blog.csdn.net/qq_37130969/article/details/82388625
 * StringBuffer类中的方法主要偏重于对于字符串的变化，例如追加、插入和删除等，这个也是StringBuffer和String类的主要区别。
 * IndexOf() 方法
	定义：查找字符串中指定字符或字串首次出现的位置，返回索引值。该方法区分大小写。
	功能：在字符串中从前向后定位字符和字符串，返回值是指定的字符在字符串中的绝对位置，如没有查到指定的字符则该方法返回-1。
 */
public class deleSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc123def123asdkfjl123";
		String str2 = "123";
		deleSubString d = new deleSubString();
		Object[] result = d.deleteSubString(str1, str2);
		System.out.println("删除字串后："+result[0]);
		System.out.println("删除了" +result[1] + "次");
	}
	
	public Object[] deleteSubString(String str1,String str2) {
		StringBuffer sb = new StringBuffer(str1);
		int delCount = 0;
		Object[] obj = new Object[2];
 
		while (true) {
			int index = sb.indexOf(str2);
			if(index == -1) {
				break;
			}
			sb.delete(index, index+str2.length());
			delCount++;
			
		}
		if(delCount!=0) {
			obj[0] = sb.toString();
			obj[1] = delCount;
		}else {
			//不存在返回-1
			obj[0] = -1;
			obj[1] = -1;
		}
		
		return obj;
	}
}
