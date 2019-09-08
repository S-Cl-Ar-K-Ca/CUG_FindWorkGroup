class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String regex = "\\(.*?\\)";
        String s = "asdfa(sfa)ssfd(sdfa)asd";
        System.out.println(s.replaceAll(regex,"+"));
    }
}
