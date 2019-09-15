package ThreadProblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CUGToda
 * @Time    2019年4月10日下午7:02:55
 * @Notice 
 */
public class ThreadPrintNum {

    public static int num=1;
    public  volatile boolean flag =false;
    Lock  LOCK=  new ReentrantLock();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreadPrintNum tNum =new ThreadPrintNum();
        Thread thread1=new Thread(new printOdd(tNum));
        Thread thread2 = new Thread(new printEven(tNum));
        Thread thread3= new Thread(new printOdd(tNum));
        Thread thread4= new Thread(new printOdd(tNum));
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
    }
}

class printOdd implements Runnable{
    private ThreadPrintNum threadPrintNum;
    public printOdd(ThreadPrintNum threadPrintNum) {
        this.threadPrintNum = threadPrintNum;
    }

    @Override
    public void run() {
        while (ThreadPrintNum.num <= 100) {
            if (!threadPrintNum.flag) {// 当flag 为false的时候 此线程负责输出奇数
                threadPrintNum.LOCK.lock();
                if (!threadPrintNum.flag) {
                    System.out.println(Thread.currentThread() + "-------" + ThreadPrintNum.num);
                    ThreadPrintNum.num++;
                    threadPrintNum.flag = true;
                }
                threadPrintNum.LOCK.unlock();
            }
        }
    }
}

class printEven implements Runnable{
    private ThreadPrintNum threadPrintNum;
    
    public printEven(ThreadPrintNum threadPrintNum) {
        this.threadPrintNum = threadPrintNum;
    }
    @Override
  public void run() {

        while (ThreadPrintNum.num <= 100) {
            if (threadPrintNum.flag) {//当flag 为true的时候 此线程负责输出奇数
                threadPrintNum.LOCK.lock();
                try {
                    System.out.println("          "+Thread.currentThread()+"获得锁 1");
                    System.out.println(Thread.currentThread()+"-------"+ThreadPrintNum.num);
                    ThreadPrintNum.num++;
                    threadPrintNum.flag=false;
                } catch (Exception e) {
                    // TODO: handle exception
                }finally {
                    threadPrintNum.LOCK.unlock();
                    System.out.println("          "+Thread.currentThread()+"释放锁 1");
                }
            }
        }
    
    }
}


//方法二
/*package ThreadProblem;

class MyTask {

   public synchronized void printNumber(int i) {
       try {
           this.notify();
           System.out.println(Thread.currentThread().getName() + " " + i);
           this.wait();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}

public class swapPrint {

   public static void main(String[] args) {
       final MyTask myTask = new MyTask();
       
       Thread t1 = new Thread(new Runnable() {

           @Override
           public void run() {
               for (int i = 1 ; i <= 1000 ; i+=2) {
                   myTask.printNumber(i);
               }
           }
       });
       
       t1.setName("Thread t1");
       t1.start();
       
       Thread t2 = new Thread(new Runnable() {

           @Override
           public void run() {
               for (int i = 2 ; i <= 1000 ; i+=2) {
                   myTask.printNumber(i);
               }
           }
       });
       
       t2.setName("Thread t2");
       t2.start();
   }
}*/


//方法三，使用yield（）方法进行测试 , 无法正确输出结果
/*package ThreadProblem;


public class printNum {
    public static void main(String[] args) {
        Thread thread1= new Thread(new OddPrint());
        Thread thread2 = new Thread(new EvenPrint());
        thread1.setPriority(2);
        thread2.setPriority(1);
        thread2.start();
        thread1.start();
        
    }
}

class OddPrint implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int  i = 1 ;i<=100;i=i+2) {
            System.out.println(Thread.currentThread()+" Print: "+i);
            Thread.yield();
        }
    }
}

class EvenPrint implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int  i = 2 ;i<=100;i=i+2) {
            System.out.println(Thread.currentThread()+" Print: "+i);
            Thread.yield();
        }
    }
}*/



//自己写的，能够输出正确结果
/*package ThreadProblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SwapPrint {
    public static int num=1;
    public volatile boolean flag=true;    
  //  Lock lock  = new ReentrantLock();
    
    public static void main(String[] args) {
         SwapPrint sp = new SwapPrint();
        Thread thread0=new Thread(new oddPrint(sp));
        Thread thread1 = new  Thread(new evenPrint(sp));
        thread0.start();
        thread1.start();
    }
}


class oddPrint implements Runnable{
    private SwapPrint sPrint;
    Lock lock = new ReentrantLock();
    
    public oddPrint( SwapPrint s) {
        // TODO Auto-generated constructor stub
        this.sPrint=s;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(sPrint.num<100) {
           //lock.lock();
            if (sPrint.flag) {
                System.out.println(Thread.currentThread()+" print: "+sPrint.num);
                sPrint.num++;
                sPrint.flag=false;
            }  
           // lock.unlock();
        }
    }
}

class evenPrint implements Runnable{
    private SwapPrint sPrint;
    Lock lock = new ReentrantLock();
    
    public evenPrint( SwapPrint s) {
        // TODO Auto-generated constructor stub
        this.sPrint=s;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(sPrint.num<100) {
          //lock.lock();
            if (!sPrint.flag) {         
                System.out.println(Thread.currentThread()+" print: "+sPrint.num);
                sPrint.num++;
                sPrint.flag=true;            
            } 
           //lock.unlock();
        }
    }
}*/