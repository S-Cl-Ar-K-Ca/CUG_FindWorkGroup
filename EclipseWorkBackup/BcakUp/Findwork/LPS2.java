package Findwork;

public class LPS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String string ="asdfaafdyweuoret";
			System.out.println(LPS(string));
	}

	public static String findLPS(String s,int left,int right) {
		while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left+1, right);
	}
	
	public static String LPS(String s) {
		String res="";
		String temp="";
		for(int i=0; i<s.length()-1;i++) {
			temp =findLPS(s, i, i);
			if(res.length() < temp.length() ) {
				res =temp;
			}
			temp=findLPS(s, i, i+1);
			if(res.length() < temp.length() ) {
				res =temp;
			}	
		}
		return res;	
	}
}
