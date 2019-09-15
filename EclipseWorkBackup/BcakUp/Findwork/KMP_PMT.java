package Findwork;
/**
 * @author hadoop
 * 使用PMT（部分匹配表的方法来）实现KMP算法   可以将暴力求解的时间复杂度O(m*n)降低为O(m+n)
 *
 */
public class KMP_PMT {
	
	public static void main(String[] args) {
/*		String s1="ababababca";
		String s2="abababca";*/
		
		String s1="qwertyuiopasdfghjklzxcvbnm";
		String s2="ghjklzxc";
		
		
		int next[]=getNext(s2);
		for (int i : next) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println(KMP(s1, s2));
		
		KMPsolutin kmPsolutin =new KMPsolutin();
		int next2[]=kmPsolutin.getNext(s2);
		for (int i : next2) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(kmPsolutin.KMP(s1, s2));
	}
	
	public static int KMP(String sourceS, String targetS) {
		int i=0;int j=0;
		int next[] =getNext(targetS);
		//重点领悟循环这段，要会写
		while(i<sourceS.length() && j<targetS.length()) {
			if (j==-1 || sourceS.charAt(i) == targetS.charAt(j)) {
				i++;
				j++;
			}else {
				j= next[j];
			}
		}
		
		if (j==targetS.length()) 
			return i-j;
		else
			return -1;
	}
	public static  int[] getNext(String s) {
		int next[] = new int[s.length()];//定义大一个，防止越界，只有前length个数据有用
		int i=0; 
		int j=-1; //求next数组的j 初始化为-1。这样设计是要使next[1]=0;
		next[0]=-1;
		//有越界就改这个地方 s.length()-1
		//这部分的循环就是字符串匹配  循环和上面很相似
		while(i<s.length()-1) {
			if(j==-1 || s.charAt(i)== s.charAt(j)) {
				next[i+1]=j+1;
				i++;
				j++;
			}else{
				//j=next[j];//一旦不匹配成功。J 一直回退到-1
				j = -1;//其实就是回退到-1, 检查这样写也是正确的
				}
			
		}
		return next;
	}

}



//2019年3月25日09:48:01
class KMPsolutin{
	public int KMP(String  source, String target) {
		int i=0; int j=0;
		int next[] =getNext(target);
		while(i<source.length() && j< target.length() ) {
			if (j==-1 || source.charAt(i) == target.charAt(j)) {
				i++;
				j++;
			}else {
				j=next[j]; //因为next数组的初始值默认是-1
			}
		}
		
		if (j==target.length()) {
			return i-j;
		}
		return -1;
	}

	public int[] getNext(String target) {
		int i=0; int j=-1;
		int next[]=new int[target.length()];
		next[0]=-1;
		
		while(i< target.length()-1) {
			if ( j==-1 || target.charAt(i) == target.charAt(j) ) {
				next[i+1]=j+1;
				i++;
				j++;
			}
			j = next[j];
		}
		return next;
	}
}