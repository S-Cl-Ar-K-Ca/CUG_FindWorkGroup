package ThreadProblem;

import java.util.LinkedList;

public class blockingQueueTest {
    private LinkedList<Object> queue= new LinkedList<Object>();
    private int size=10;
    
    public blockingQueueTest(int size) {
        // TODO Auto-generated constructor stub
        this.size = size;
    }
    
    public  synchronized void enqueue(Object item) throws InterruptedException {
        if (this.queue.size()==this.size) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }
    
    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size()==0) {
            wait();
        }
        if (this.queue.size()==this.size) {
            notifyAll();
        }
        return this.queue.removeFirst();
    }
}
