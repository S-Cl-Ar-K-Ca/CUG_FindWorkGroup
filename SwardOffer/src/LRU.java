import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author CUGToda
 * @Time    2019年4月10日下午8:03:25
 * @Notice LRU 算法使用LinkedHashMap来实现 ，Least Recently Used。华为笔试
 * @param <K>
 * @param <V>
 */
public class LRU<K, V> {
    private int size;
    private LinkedHashMap<K, V> map;


    public LRU(int size) {
        // TODO Auto-generated constructor stub
        this.setSize(size);
        int initialCapacity =(int)(size / 0.75)+1;
        map =  new LinkedHashMap<K,V>(initialCapacity, 0.75f, true) {
            private static final long serialVersionUID = 1L;
            /**
             * @Notice :重写这个方法，返回值为true 时会将按照访问顺序存放在尾部最后面的一个值给移除
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldestEntry) {
                return size() > size;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key,V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int getCurrentSize() {
        return map.size();
    }

    public void print () {
        for (Map.Entry<K, V> entry  : map.entrySet()) {
            System.out.print(entry.getKey()+"-"+entry.getValue()+" ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        LRU<Integer, Integer> lruTest=new LRU<>(5);
        lruTest.put(2, 2);
        lruTest.put(1, 1);
        lruTest.put(2, 22);
        lruTest.put(3, 3);
        lruTest.put(5, 5);
        lruTest.put(7,7);
        lruTest.get(2);
        lruTest.put(6, 6);
        lruTest.print();
    }
}
