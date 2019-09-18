public class SangforSolution2 {
    public static void main(String[] args) {
        SangforSolution2 s2 = new SangforSolution2();
        System.out.print("heshi"+s2.add(1,1));
    }
    public int add(int a ,int b){
        try{
            return a+b;
        }catch (Exception e){
            System.out.print("catch");
        }finally {
            System.out.print("finally");
        }
        return 0;
    }
}
