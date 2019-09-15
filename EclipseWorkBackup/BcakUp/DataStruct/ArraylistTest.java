
import java.util.ArrayList;

/**
 * @author hadoop 掌握数组列表（Arraylist）的特性：仍然是顺序存储，以下标检索，以循环遍历来查找
 */
public class ArraylistTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 创建一个ArrayList对象
        ArrayList<Student> al = new ArrayList<Student>();
        System.out.println("ArrayList的size " + al.size());// 打印出ArrayList的size，可以像数组一样查看size
        Student a = new Student("Alice", 20, 93);
        Student b = new Student("Bob", 21, 98);
        Student c = new Student("Kive", 24, 89);
        al.add(a);// 直接可以添加object对象
        al.add(b);
        al.add(c);
        al.add(3, c);// 其也可以在指定位置插入元素 Exception in thread "main"
                     // java.lang.IndexOutOfBoundsException: Index: 5, Size: 3
        System.out.println("ArrayList的size " + al.size());
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i).name + " ");
        }
        /*
         * System.out.println("ArrayList的size "+al.size());//打印出ArrayList的size，
         * 可以像数组一样查看size
         * 
         * System.out.println( ((Student)al.get(0)).name
         * );//通过下标访问数据对象及其属性，是顺序存储的,同时需要强制类型转换一波
         * 
         * for(int i =0;i<al.size();i++) {
         * System.out.print(((Student)al.get(i)).name+ " "); }
         * 
         * //如果插入同一对象，依然在最后插入，不去重 al.add(a); al.add(b); al.add(c);
         * System.out.println(); for(int i =0;i<al.size();i++) {
         * System.out.print(((Student)al.get(i)).name+ " "); }
         * 
         * //删除对象 al.remove(3); System.out.println(); for(int i
         * =0;i<al.size();i++) { System.out.print(((Student)al.get(i)).name+
         * " "); }
         */
        StuManage sm = new StuManage();
        sm.addStu(a);
        sm.addStu(c);
        sm.addStu(b);
        sm.fixScore("fin", 100);
    }
}

// 学生管理类
class StuManage {

    ArrayList<Student> a = null;

    public StuManage() {
        a = new ArrayList<>();
    }

    // 修改学生分数
    public void fixScore(String name, double score) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).name.equals(name)) {
                // a.get(i).score= score;
                a.get(i).setScore(score);
                return;
            }
        }
        System.out.println("not match");
        return;
    }

    public void addStu(Student student) {
        a.add(student);
    }

    public Student findName(String s) {
        Student temp = null;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).name.equals(s)) {
                temp = a.get(i);
                return temp;
            }
        }
        return null;
    }
}

class Student {

    String name;

    int age;

    double score;

    public Student(String s, int a, double b) {
        this.name = s;
        this.age = a;
        this.score = b;
    }

    // 修改属性
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // 返回属性
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}
