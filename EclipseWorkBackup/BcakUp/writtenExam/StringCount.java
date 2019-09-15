package writtenExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StringCount {

    public static void main(String[] args) throws IOException {
        StringCountAndSort("H:\\test.txt", "H:\\out.txt");
    }

    public static void StringCountAndSort(String pathIn, String pathOut) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathIn), "utf-8"));// 读取文件
        String string = null;
        HashMap<String, Integer> hm = new HashMap<>();// 利用hashmap，统计（去重）
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathOut), "utf-8"));// 写出结果
        while ((string = reader.readLine()) != null) {// 按行读取字符，并将其put入hm
            if (!hm.containsKey(string)) {
                hm.put(string, 1);
            }
            hm.put(string, hm.get(string) + 1);
        }
        reader.close();
        ArrayList<Map.Entry<String, Integer>> aList = new ArrayList<>(hm.entrySet());// 利用hashmap的entrySet来建造list，collections可以对list进行排序
        Collections.sort(aList, new Comparator<Map.Entry<String, Integer>>() {

            // comparator的用法在最后讲解
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : aList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            writer.write(entry.getKey() + ": " + entry.getValue());// 将排好序的list写入到文件中
            writer.newLine();
        }
        writer.close();
    }
    
    /**
     * @param line  读文本文件中的一行
     * @param scale  分词的大小（可按照1词1分，2词1分、、、等多种规格分词）
     * @return
     */
    @SuppressWarnings("unused")
    private static String[] lineParser(String line, int scale){
        String[] lineDicts = null;
        if(line != null && !"".equals(line.trim())){
            String[] spliter = line.split("\\s+|,");//按照空格或者“，”进行分割
            ArrayList<String> container = new ArrayList<String>();

            for(int i=0; i<spliter.length; i += scale){
                StringBuilder phase = new StringBuilder("");

                for(int j=0; (i+j) < spliter.length && j<scale; j++){
                    phase.append(spliter[i+j]).append(" ");
                } 

                String phaseStr = phase.toString().trim();
                if("".equals(phaseStr)){
                    continue;
                }
                container.add(phaseStr);
            }
            lineDicts = new String[container.size()];
            container.toArray(lineDicts);
        }
        return lineDicts;
    } 
}
