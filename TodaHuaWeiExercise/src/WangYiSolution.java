import java.util.*;

public class WangYiSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int []inputs = new int[size*2];
        for (int i=0;i< size*2;i++){
            inputs[i] = scanner.nextInt();
        }
        ArrayList arrayList = new ArrayList();
        for (int i=0;i< size*2;i=i+2){
            HashMap<Character,Integer> a  = new HashMap<>();
            a = GetResult01(inputs[i],inputs[i+1]);
            System.out.println(GetResult02(a));
            arrayList.add(a);
        }
        GetResult03(arrayList);

    }
    public static HashMap<Character,Integer> GetResult01(int a,int b){
        HashMap<Character,Integer> res  = new HashMap<>();
        if(a <= 0 ||  a>=1000 || b <= 0 ||  b>=1000){
            return res;
        }
        int size = String.valueOf(b).length();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(a);
        nums.add(b);
        nums.add(a*b);
        for (int i = size-1; i >= 0; i--) {
            nums.add( a* Character.getNumericValue(String.valueOf(b).charAt(i)));
        }

        for (Integer i:nums) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length() ; j++) {
                if(!res.keySet().contains(s.charAt(j))){
                    res.put(s.charAt(j),1);
                }else {
                    res.put(s.charAt(j),res.get(s.charAt(j))+1);
                }
            }
        }
        return res;
        /*int num[] = new int[size];
        char charA[] = String.valueOf(a).toCharArray();
        char charB[] = String.valueOf(b).toCharArray();*/
    }

    public static String GetResult02(HashMap<Character,Integer> input){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i =1 ; i<10; i++){
            char c = (char)(i+48);
            if(!input.keySet().contains(c)){
                stringBuffer.append("0").append(" ");
            }else {
                stringBuffer.append(input.get(c)).append(" ");
            }
        }
        return stringBuffer.toString().trim();
    }

    public static void GetResult03(ArrayList<HashMap<Character,Integer>> input){
        HashMap<Character,Integer> last  = new HashMap<>();

        for (int i = 1;i<10;i++){
            Integer value = 0;
            char c = (char)(i+48);
            for (HashMap<Character,Integer> map:input) {
                if(map.keySet().contains(c)){
                    value = value + map.get(c);
                }
            }
            last.put(c,value);
        }
        ArrayList<Map.Entry<Character,Integer>> res = new ArrayList<>(last.entrySet());
        Collections.sort(res, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        System.out.print(res.get(0).getKey());
    }


}
