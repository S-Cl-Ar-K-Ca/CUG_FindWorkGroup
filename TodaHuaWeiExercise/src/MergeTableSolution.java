import java.util.*;

public class MergeTableSolution {
    public static void main(String[] args) {
        HashMap<Long,Long> table = new HashMap();
        Scanner scanner = new Scanner(System.in);
        long count = scanner.nextLong();
        for (long i = 0; i < count; i++) {
            long key = scanner.nextLong();
            long value = scanner.nextLong();
            if(table.keySet().contains(key)){
                table.put(key,table.get(key)+value);
            }else {
                table.put(key,value);
            }
        }
        ArrayList<Map.Entry<Long,Long>> arrayList= new ArrayList<>(table.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<Long,Long>>() {
            @Override
            public int compare(HashMap.Entry<Long,Long> o1, HashMap.Entry<Long,Long> o2) {
                return o1.getKey()-o2.getKey() > 0 ? 1 : -1;
            }
        });
        for (Map.Entry<Long,Long> e:arrayList) {
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
}
