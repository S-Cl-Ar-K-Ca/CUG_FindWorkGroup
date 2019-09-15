package Findwork;

import java.util.HashMap;

public class countNum {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 1, 0, 2, 1, 0, 0, 1, 0, 0, 1, 1, 2 };
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        int res[]=count(arr);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }

    public static int[] count(int arr[]) {
        int res[] = new int[arr.length];
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hMap.containsKey(arr[i])) {
                hMap.put(arr[i], 1);
            } else {
                hMap.put(arr[i], hMap.get(arr[i]) + 1);
            }
        }
        System.out.println(hMap.get(0));
        for(int j=0;j<hMap.get(0); j++) {
            res[j]=0;
        }
        for (int j=hMap.get(0);j<hMap.get(1)+hMap.get(0);j++) {
            res[j]=1;
        }
        for (int j=hMap.get(0)+hMap.get(1);j<res.length;j++) {
            res[j]=2;
        }
        //用作hashmap转成ArrayList进行排序的工作
/*        ArrayList<Map.Entry<Integer, Integer>> al = new ArrayList<>(hMap.entrySet());
        Collections.sort(al, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : al) {
            System.out.println(entry.getKey() + ":  " + entry.getValue());
        }*/
        return res;
    }
}
