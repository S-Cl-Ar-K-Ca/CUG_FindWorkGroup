
import java.util.Vector;

/**
 * @author hadoop
 *它的实现与 ArrayList 类似，但是使用了 synchronized 进行同步。
 * 与 ArrayList 的比较
*Vector 是同步的，因此开销就比 ArrayList 要大，访问速度更慢。最好使用 ArrayList 而不是 Vector，因为同步操作完全可以由程序员自己来控制；
*Vector 每次扩容请求其大小的 2 倍空间，而 ArrayList 是 1.5 倍。
 */
public class VectorTest {
	public static void main(String[] args) {
		Vector<Student> VV=new Vector<>();
		
		Student a = new Student("Alice", 20, 93);
		Student b = new Student("Bob", 21, 98);
		Student c = new Student("Kive", 24, 89);
		
		VV.add(a);
		VV.add(b);
		VV.add(c);
	//	VV.add(5, a); //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5 > 3
		VV.add(3, a);
		for(int i=0 ;i<VV.size();i++) {
			System.out.print(VV.get(i).name+" ");
		}
	}
}
