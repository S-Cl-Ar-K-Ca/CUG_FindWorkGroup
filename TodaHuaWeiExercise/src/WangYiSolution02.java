import java.util.*;

public class WangYiSolution02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String s[] = new String[size];
        for (int i = 0; i < size; i++) {
            s[i] = scanner.next();
        }
        for (int i = 0; i <size ; i++) {
            getResult(GetResult(s[i]));
        }
    }
    public static String GetResult(String s){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s.charAt(0));
        for (int i = 1; i < s.length() ; i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                continue;
            }else {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
    public static void getResult(String s){
        if(null == s || s.length()<=0){
            System.out.println("0");
        }
        if(s.length()<= 6){
            System.out.println(s.length()-1);
        }else{
            GetResult03(s);
        }
    }
    public  static void GetResult03(String s){
        TuNode head =  new TuNode(s.charAt(0));
        TuNode cur = head;
        StringBuffer stringBuffer = new StringBuffer();
        int initialCapacity =(int)(8 / 0.75)+1;
         LinkedHashMap<Character, Integer>  set =  new LinkedHashMap(initialCapacity, 0.75f, true) {
            private static final long serialVersionUID = 1L;
            /**
             * @Notice :重写这个方法，返回值为true 时会将按照访问顺序存放在尾部最后面的一个值给移除
             * @param eldestEntry
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry eldestEntry) {
                return size() > 6;
            }
        };
        for (char c: s.toCharArray()) {
                set.put(c,0);

        }
        if(set.size()<6){
            System.out.println((s.length()-1)*2);
            return;
        }
        for (Character c:set.keySet()) {
            stringBuffer.append(s);
        }
        String jianpan = stringBuffer.toString();

    }
}

class TuNode{
   public Character c;
   public TuNode pre ;
   public TuNode next;

    public TuNode(char c){
        this.c = c;
    }
}