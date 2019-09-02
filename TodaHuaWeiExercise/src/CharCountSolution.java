import java.util.*;

public class CharCountSolution {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char c =scanner.next().charAt(0);
            System.out.println(charCount(s,c));
        }
    }

    public static int charCount(String s, char a){
        Map<Character,Integer> hashmap = new HashMap<>();
        for (char c:s.toCharArray()) {
            if(Character.isLowerCase(c)){
                c = Character.toUpperCase(c);
            }
           if(hashmap.keySet().contains(c)){
               hashmap.put(c,hashmap.get(c)+1);
           }else {
               hashmap.put(c,1);
           }
        }
        if(Character.isLowerCase(a)){a = Character.toUpperCase(a);}
        if(hashmap.keySet().contains(a)){
            return hashmap.get(a);
        }
        return 0;
    }

}
