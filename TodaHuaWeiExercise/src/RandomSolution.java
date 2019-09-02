import java.util.*;

public class RandomSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int size = scanner.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
            for (Object i: getSetSort(arr)) {
                System.out.println(i);
            }
        }
    }

    public static ArrayList getSetSort(int arr[]){
        Set arrSet = new HashSet();
        for (int i:arr) {
            arrSet.add(i);
        }
        ArrayList arrayList = new ArrayList(arrSet);
        Collections.sort(arrayList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }
        );
        return arrayList;
    }
}
