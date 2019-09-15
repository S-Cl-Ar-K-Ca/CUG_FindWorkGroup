package Findwork;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hadoop
 *	Longest no repeating substring  		最长无重复字符串
 *要求得到一个字符串的最长不重复子串的长度
 */
public class LNRS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String string="abcabcdabcdeababcdfgh";
		String string2 ="abcdabc";
		System.out.println( getSizeofLNRS(string) );
		System.out.println(getLNRS(string));
		System.out.println( getSizeofLNRS(string2) );
		System.out.println(getLNRS(string2));
		System.out.println(getLofLNRP(string));
		System.out.println(getLofLNRP(string2));

	}
	
	// 使用hashmap 来做,时间复杂度大概是o(n)
	public static int getSizeofLNRS(String s) {
		HashMap<Character, Integer> hMap = new HashMap<>();
		int i=0, pos =0;
		int res =0;
		
		for (;i<s.length();i++) {
			if (hMap.containsKey(s.charAt(i))) {
				pos = Math.max(hMap.get(s.charAt(i)), pos);
			}
			res=Math.max(res, i-pos+1);
			hMap.put(s.charAt(i), i+1);
		}
		return res;
	}
	//用hashmap来输出LNRS
	public static String getLNRS(String s) {
		HashMap<Character, Integer> hMap = new HashMap<>();
		int i=0, pos =0; int mark=0;
		int res =0;
		
		for (;i<s.length();i++) {
			if (hMap.containsKey(s.charAt(i))) {
			    pos = Math.max(hMap.get(s.charAt(i)), pos);;
			}
			res=Math.max(res, i-pos+1);
			if(res == i-pos+1) {
				mark=i;
			};
			hMap.put(s.charAt(i), i+1);
		}
		return s.substring(mark-res+1, mark+1);
	}
	
	//使用hashset来做  时间会比hashmap长，大概是0(n2)
	public static int getLofLNRP(String s) {
		HashSet<Character> hSet=new HashSet<>();
		int start=0;int end=0;
		int res=0;
		while(start<s.length() && end<s.length()) {
			if (hSet.contains(s.charAt(end))) {
				hSet.remove(s.charAt(start));
				start++;
				
			}
			hSet.add(s.charAt(end));
			end++;
			res=Math.max(res, end-start);
		}
		return res;
	}

}
