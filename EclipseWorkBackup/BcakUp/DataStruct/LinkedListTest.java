
import java.util.*;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			// TODO Auto-generated method stub
			
			Student a = new Student("Alice", 20, 93);
			Student b = new Student("Bob", 21, 98);
			Student c = new Student("Kive", 24, 89);
			
			LinkedList<Student> ll=new LinkedList<>();
			
			//相较于数组列表的特有，可以在头部插入（后进的在前面，栈）,  也可以在直接removeFirst和removeLast
			//相较于数组列表的特有，可以在尾部插入（后进的在前面，队列）
			//并且可以在指定index插入元素
			ll.addFirst(a);
			ll.addFirst(b);
			ll.addFirst(c);
			ll.add(3, a); //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 5, Size: 3
			//ll.removeFirst();
			//ll.removeLast();
			System.out.println(ll.get(3).score);
			for(int i=0 ;i< ll.size();i++) {
				System.out.print(ll.get(i).name+" ");
			}


	}

}
