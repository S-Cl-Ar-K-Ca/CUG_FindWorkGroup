public class ReverseString {
    public static void main(String[] args) {
        String test = "HelloEveryone";
        System.out.println("reverseStr01"+": "+reverseStr01(test));
        System.out.println("reverseStr02"+": "+reverseStr02(test));
        System.out.println("reverseStr03"+": "+reverseStr03(test));
    }

    /*
    * 1.使用自带的stringbuffer来反转字符串
    * */
    public static String reverseStr01(String string){
        StringBuffer stringBuffer= new  StringBuffer();
        return stringBuffer.append(string).reverse().toString();
    }

    /*
     * 2.使用递归来实现字符串反转
     * */
    public static String reverseStr02(String string){
        if(string.equals("") || null == string){
            return  string;
        }
        return string.charAt(string.length()-1) + reverseStr02(string.substring(0,string.length()-1));
    }

    /*
    * 3.普通方法来做
    * */
    public static String reverseStr03(String string){
        char []chars = string.toCharArray();
        char temp;
        for(int i = 0; i < string.length()/2; i++){
            temp = chars[i];
            chars[i] = chars[string.length()-1-i];
            chars[string.length()-1-i] = temp;
        }
        return String.valueOf(chars);
    }
}
