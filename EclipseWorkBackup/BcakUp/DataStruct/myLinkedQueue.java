  /**
 * @author CUGToda
 * @Time    2019年4月17日下午3:20:26
 * @Notice   手写循环队列
 */
public class myLinkedQueue {
    int size;
    int front;
    int tail;
    int queueList[];
 
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
    public myLinkedQueue(int size) {
        // TODO Auto-generated constructor stub
        this.size =size;
        queueList = new int [size];
        front=0; tail=0;
    }
    
    public boolean isEmpty() {
        if (front == tail) {
            return true;
        }else {
            return false;
        }
    }
    
    public boolean isFull () {
        if ((tail+1)%size == front) {
            return  true;
        }else {
            return  false;
        }
    }
    
    public void enQueue(int data) {
        if(isFull()) {
            System.out.println("is full");
            return;
        }
        tail = (tail+1)%size;
        queueList[tail]=data;
    }
    
    public int deQueue() {
        if(isEmpty()) {
            System.out.println("is Empty");
            return Integer.MIN_VALUE;
        }
       int res= queueList[front];
       front=(front+1)%size;
       return res;       
    }
}
