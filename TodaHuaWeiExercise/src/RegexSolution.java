public class RegexSolution {
    /*https://www.cnblogs.com/xhj123/p/6032683.html*/
    public static void main(String[] args) {
        String s = "1234567";
        String regex = "\\d+";
        System.out.println(s.matches(regex));

        String s2 = "1234567abdcAa3";
        String regex2 = "\\w{10,}";
        System.out.println(s2.matches(regex2));

        String s3 = "1234567abdcAa@3$abc";
        String regex3 = "[a-zA-Z]+|[^0-9a-zA-Z]+";
        String regex4 = "[^0-9]";
        String regex5 = "[^0-9]+";
        System.out.println(s3);
        System.out.println(s3.replaceAll(regex3,"*"));
        System.out.println(s3.replaceAll(regex4,"*"));
        System.out.println(s3.replaceAll(regex5,"*"));

        String s4 = "YUANzhi1987";
        System.out.println(s4.replaceAll("[w-z]","1"));
    }
}
