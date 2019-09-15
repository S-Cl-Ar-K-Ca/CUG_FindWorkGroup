
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		int arr[]= {0,9,2,7,4,8,6,3,1,5,5,1,3,6,8,4,7,2,9,0};
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		iAddK(arr, 3);
	}
	
	//给定数组arr[ ]、给定差值K，输出数组arr[ ]中的所有差值为K的数对
	public static void iAddK(int arr[], int k) {
		HashSet<Integer> hset = new HashSet<>();
		//往hashset里面添加数据，自动去重
		for(int i=0 ;i< arr.length; i++) {
			hset.add(arr[i]);
		}
		for (Iterator<Integer> i2 = hset.iterator(); i2.hasNext();) {
			Integer iiInteger = i2.next();
			System.out.print(iiInteger+" ");
		}
		System.out.println();
		Iterator<Integer> iterator = hset.iterator();
		while (iterator.hasNext()) {
				int i = iterator.next();
				if (hset.contains(i+k)) {
					System.out.println(i+" "+(i+k));
				}
		}
	}
}
