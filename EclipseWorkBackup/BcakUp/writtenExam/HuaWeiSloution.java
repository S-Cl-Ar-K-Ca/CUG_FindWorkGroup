package writtenExam;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*public class HuaWeiSloution {
    public static void main(String[] args) {
        control c = new control("H:\\in01.txt", "H:\\in02.txt","H:\\out.txt");
        Thread thread01= new Thread(new ReadOdd(c));
        Thread thread02= new Thread(new ReadEvent(c));
        thread01.start();
        thread02.start();
    }
    
}

class control{
    public volatile boolean flag=false;
    ReentrantLock lock =new ReentrantLock();  
    public String pathIn01;
    public String pathIn02;
    public String pathOut;
    
    public control(String s1,String s2,String s3) {
        // TODO Auto-generated constructor stub
        this.pathIn01=s1;
        this.pathIn02=s2;
        this.pathOut=s3;
    }
    
}

class ReadOdd implements Runnable{
    private control c;
    public ReadOdd(control control) {
        // TODO Auto-generated constructor stub
        this.c=control;
    }
    
    @Override
    public void run()  {
        // TODO Auto-generated method stub
        try {
            @SuppressWarnings("resource")
            BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(c.pathIn01)));
            String  temp = reader.readLine();
            while (temp != null && !c.flag) {
                if (!c.flag) {
                   // c.lock.lock();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c.pathOut)));
                    writer.newLine();
                    writer.write(temp);
                    c.flag = true;
                    writer.close();
                    //c.lock.unlock();
                }
            }
            //reader.close();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class ReadEvent implements Runnable{
    private control c;
    public ReadEvent(control control) {
        // TODO Auto-generated constructor stub
        this.c=control;
    }
    
    @Override
    public void run()  {
        // TODO Auto-generated method stub
        try {
            @SuppressWarnings("resource")
            BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(c.pathIn02)));
            String  temp = reader.readLine();
            while (temp != null && c.flag) {
                if (c.flag) {
                    //c.lock.lock();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c.pathOut)));
                    writer.newLine();
                    writer.write(temp);
                    c.flag = false;
                    writer.close();
                    //c.lock.unlock();
                }
            }
           // reader.close();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}*/
// 上面这个多线程的方法来读写a.txt文件 和 b.txt文件中的word 交替 写入到c.txt文件中失败


  
class MainClass{  
    public static void main(String[] args) throws Exception{  
        FileManager a = new FileManager("a.txt",new char[]{'\n'});  
        FileManager b = new FileManager("b.txt",new char[]{'\n',' '});        
        FileWriter c = new FileWriter("c.txt");  
        String aWord = null;  
        String bWord = null;  
        while((aWord = a.nextWord()) !=null ){  
            c.write(aWord + "\n");  
            bWord = b.nextWord();  
            if(bWord != null)  
                c.write(bWord + "\n");  
        }  
          
        while((bWord = b.nextWord()) != null){  
            c.write(bWord + "\n");  
        }     
        c.close();  
    }  
      
}  
  
  
class FileManager{  
  
    String[] words = null;  
    int pos = 0;  
    public FileManager(String filename,char[] seperators) throws Exception{  
        File f = new File(filename);  
        @SuppressWarnings("resource")
        FileReader reader = new FileReader(f);  
        char[] buf = new char[(int)f.length()];  
        int len = reader.read(buf);  
        String results = new String(buf,0,len);  
        String regex = null;  
        if(seperators.length >1 ){  
            regex = "" + seperators[0] + "|" + seperators[1];  
        }else{  
            regex = "" + seperators[0];  
        }  
        words = results.split(regex);  
    }  
      
    public String nextWord(){  
        if(pos == words.length)  
            return null;  
        return words[pos++];  
    }  
  
}