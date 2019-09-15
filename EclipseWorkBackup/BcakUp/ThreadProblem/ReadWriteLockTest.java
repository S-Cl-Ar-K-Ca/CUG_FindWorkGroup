package ThreadProblem;
/**
 * @author hadoop
 * https://ifeve.com/read-write-locks/  并发编程网中的关于读写锁的简单实现
 * 
 * 下面是简单实现的读写锁，但是还没有实现重入
 * 实现重入之后，就要实现锁降级和锁升级
 */
public class ReadWriteLockTest {
    private static volatile  int   read;
    private static volatile int   write;
    private static volatile  int  writeRequest;
    
    public synchronized void readLock() throws InterruptedException {
        while(write >0 || writeRequest>0) {
            wait();
        }
        read++;
    }
    
    public synchronized void readUnlock() {
        read--;
        notifyAll();
    }
    
    public synchronized void writeLock() throws InterruptedException {
        writeRequest++;
        while (read>0 || write>0) {
            wait();
        }
        writeRequest--;
        write++;    
    }
    
    public synchronized void writeUnlock() {
        write--;
        notifyAll();
    }
    
/*    public synchronized void writeToRead() {
        if(writeRequest!=0) {
        }
    }*/
}
