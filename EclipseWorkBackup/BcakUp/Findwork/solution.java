package Findwork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author CUGToda
 * @Time    2019年4月17日下午9:11:00
 * @Notice  最长回文字符串代码  + 两个数组的交际
 */
public class solution {
    public static void main(String [] args) {
        System.out.println(LongestPailrome("sdhfjahsdfhjaaaaaaaaajhsdfjhasdhf"));
    }
    public static String LongestPailrome(String  string) {
        String result = "";//注意这里不能够使用null , 会报出空指针错误
        String temp;
        if (string.length()<=1 || string==null) {
            return string;
        }
        for(int i = 0;i < string.length()-1; i++) {
            temp = Find(string, i, i);
            if( result.length()< temp.length()) {
                result = temp;
            }
            
            temp = Find(string, i, i+1);
            if(result.length()<temp.length()) {
                result = temp;
            }
        }
        return result;
    }
    
    public static String Find(String string,int left,int right) {
        if(string.length()<=1) {
            return string;
        }
        while (left >= 0 && right <= string.length()-1 && string.charAt(left) == string.charAt(right)) {
            left--;
            right++;
        }
        return string.substring(left+1, right);
    }
}

class solution2 {
    public int[] intersection(int [] nums1,int [] nums2) {
        HashMap<Integer, Integer> h = new HashMap<>();
        HashSet<Integer> hashSet1 =new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        if(nums1.length < nums2.length) {
            int [] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        for(int i =0 ;i < nums1.length;i++) {
            hashSet1.add(nums1[i]);
        }
        for(int i =0; i<nums2.length ;i++) {
            hashSet2.add(nums2[i]);
        }
        for(int i= 0; i< nums2.length; i++) {
            if (hashSet1.contains(nums2[i]) && hashSet2.contains(nums2[i])) {
               h.put(nums2[i], 0);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(h.entrySet());
        arrayList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                // TODO Auto-generated method stub
                return e2.getValue() - e1.getValue();
            }
        });
        int res[]=new int [h.size()];int i=0;
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            res[i++]=entry.getKey();
        }
        return res;
    }
}
