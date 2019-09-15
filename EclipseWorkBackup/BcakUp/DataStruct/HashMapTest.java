
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Student a = new Student("Alice", 20, 93);
        Student b = new Student("Bob", 21, 98);
        Student c = new Student("Kive", 24, 89);
        HashMap<String, Student> hm = new HashMap<>();
        // 往hashmap中存放数值对
        hm.put("Alice", a);
        hm.put("Bob", b);
        hm.put("Kive", c);
        String s = "Alice";
        // 查找是否存在
        if (hm.containsKey(s)) {
            System.out.println("存在");
            System.out.println(hm.get(s).score);
        } else {
            System.out.println("NOT FOUND");
        }
        // 按照Key值，查找分数属性
        Iterator<String> it = hm.keySet().iterator();
        while (it.hasNext()) {
            // 取出key值
            String key = it.next().toString();
            System.out.print(key + hm.get(key).age + hm.get(key).score + " |");
        }
        // 相同键值对处put会形成覆盖
        hm.put("Alice", c);
        System.out.println();
        // hashmap的几种遍历方法
        for (Iterator<String> it2 = hm.keySet().iterator(); it2.hasNext();) {
            String key = it2.next();
            System.out.print(key + hm.get(key).age + hm.get(key).score + " |");
        }
        System.out.println();
        // 方法二 遍历key值集合，能够找到key+value
        for (String key : hm.keySet()) {
            System.out.print(key + hm.get(key).age + hm.get(key).score + " |");
        }
        System.out.println();
        // 方法三 遍历value集合，只能够输出value集合
        for (Student stu : hm.values()) {
            System.out.print(stu.name + " ");
        }
        System.out.println();
        // 方法四 推荐使用这种， 尤其是在容量较大时候 entrySet（条目集合）
        for (Map.Entry<String, Student> entry : hm.entrySet()) {
            System.out.print(entry.getKey() + entry.getValue().age + entry.getValue().score + " |");
        }
    }
}
