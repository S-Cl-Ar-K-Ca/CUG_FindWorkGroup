import java.util.*;

public class BaiduSolution01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            long m = scanner.nextLong();
            HashMap<Long,Long> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long key = scanner.nextLong();
                long value = scanner.nextLong();
                hashMap.put(key,value);
            }
            ArrayList<Map.Entry<Long,Long>> arrayList = new ArrayList<>(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<Long, Long>>() {
                @Override
                public int compare(Map.Entry<Long, Long> o1, Map.Entry<Long, Long> o2) {
                    return (o2.getKey()- o1.getKey())>0 ? 1:-1;
                }
            });
            long res = 0;
            ArrayList<Map.Entry<Long,Long>> arrayList2 = new ArrayList<>(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
               if(arrayList.get(i).getKey() >= m){
                   res = res + arrayList.get(i).getValue();
                   hashMap.entrySet().remove(arrayList.get(i));
                   arrayList2.remove(i);
               } else {
                   /*if(hashMap.keySet().contains(m-arrayList.get(i).getKey())){
                       long a = arrayList.get(i).getValue();
                       long b = hashMap.get(m-arrayList.get(i).getKey();
                       res = res + Math.min(a,b);
                       hashMap.entrySet().remove()
                   }*/
                   if((arrayList.get(i).getValue() + arrayList.get(arrayList.size()-1).getValue()) >= m){
                       long a = arrayList.get(i).getValue();
                       long b = arrayList.get(arrayList.size()-1).getValue();
                       res = res + Math.min(a,b);
                       if(a>b){
                           arrayList2.remove(arrayList.size()-1);
                           arrayList2.get(i).setValue(a-b);
                       }else {
                           arrayList2.remove(i);
                           arrayList2.get(arrayList.size()-1).setValue(b-a);
                       }
                   }
               }
            }

            while (arrayList2.size()>0){
                res = arrayList.get(0).getKey() * arrayList.get(0).getValue() / m;
                arrayList2.remove(0);
            }

            System.out.println(res);
        }
        scanner.close();
    }
}
/*
{
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = scanner.nextInt();
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i:arr) {
        if(!(hashMap.keySet().contains(i))){
        hashMap.put(i,1);
        }else {
        hashMap.put(i,hashMap.get(i)+1);
        }
        }
        int res = 0;
        for (Integer i :hashMap.keySet()) {
        if(hashMap.get(i)%2 == 0){
        res =  res + hashMap.get(i)/2;
        }else {
        res = res + hashMap.get(i)/2 +1;
        }
        }
        System.out.println(res);
        }*/
