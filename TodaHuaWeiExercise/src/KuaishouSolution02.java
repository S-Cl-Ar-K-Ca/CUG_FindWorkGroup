import java.util.*;

public class KuaishouSolution02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        print(getCombinations(input));
    }
    private static final Map<Character, char[]> keyMaps = new HashMap<Character, char[]>();
    static {
        keyMaps.put('0', new char[] {});
        keyMaps.put('1', new char[] {});
        keyMaps.put('2', new char[] { 'a', 'b', 'c' });
        keyMaps.put('3', new char[] { 'd', 'e', 'f' });
        keyMaps.put('4', new char[] { 'g', 'h', 'i' });
        keyMaps.put('5', new char[] { 'j', 'k', 'l' });
        keyMaps.put('6', new char[] { 'm', 'n', 'o' });
        keyMaps.put('7', new char[] { 'p', 'q', 'r', 's' });
        keyMaps.put('8', new char[] { 't', 'u', 'v' });
        keyMaps.put('9', new char[] { 'w', 'x', 'y', 'z' });
    }

    public static List<String> getCombinations(String number) {
        List<String> list = new ArrayList<String>();
        char firstChar = number.charAt(0);
        char[] firstCharKeyValue = keyMaps.get(firstChar);

        if (null == firstCharKeyValue || firstCharKeyValue.length == 0) {
            list = getCombinations(new String(number.substring(1)));
        } else {
            if (number.length() == 1) {
                for (char keyValue : firstCharKeyValue) {
                    list.add(String.valueOf(keyValue));
                }
            } else if (number.length() > 1) {
                List<String> valueList = getCombinations(new String(number
                        .substring(1)));
                for (char keyValue : firstCharKeyValue) {
                    for (String vl : valueList) {
                        list.add(keyValue + vl);
                    }
                }
            }
        }
        return list;
    }

    public static void print(List<String> list){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
       // String string[] = (String[]) list.toArray();
       // Arrays.sort(string);
        for (String s:list) {
            stringBuffer.append(s).append(", ");
        }
        stringBuffer.append("]");
        int index = stringBuffer.toString().lastIndexOf(",");
        String res = stringBuffer.deleteCharAt(index).toString();
        System.out.print(res);
    }

   /* public static ArrayList<String> solution(String input) throws Exception {
        HashMap<Character,String> zidian = new HashMap<>();
        zidian.put('1',"");
        zidian.put('2',"abc");
        zidian.put('3',"def");
        zidian.put('4',"ghi");
        zidian.put('5',"jkl");
        zidian.put('6',"mno");
        zidian.put('7',"pqrs");
        zidian.put('8',"tuv");
        zidian.put('9',"wxyz");
        input=input.replaceAll("1","").replaceAll("0","");
        if(input.length()<1||input.length()>20){
            throw new Exception("voild");
        }
        String s[] = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            s[i]=zidian.get(input.charAt(i));
        }
        ArrayList<String> res = new ArrayList<>();
        int count=0;
        StringBuffer stringBuffer= new StringBuffer();
        while (count<s.length){
           stringBuffer.delete(0,stringBuffer.length());
            for (int i = 0; i < s[count].length(); i++) {
                stringBuffer.append(s[count].charAt(i));
                for (int j = 0; j < 4; j++) {
                    
                }
            }
        }
    }*/
}
