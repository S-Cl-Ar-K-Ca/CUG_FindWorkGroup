public class myStack {
    private Object data[];
    private int pos=-1;
    private int size;
    
    public myStack(int size)  {
        // TODO Auto-generated constructor stub
        this.size=size;
        data=new Object[size];
    }
    
    //入栈的操作，需要判断stack是否已满
    public void push(Object object) {
        if (pos==size-1) {
            throw new StackOverflowError();
        }
        pos++;
        data[pos]=object;
    }
    
    public Object pop() {
        if (pos<0) {
            System.out.println("StackIsEmpty");
          return null;
        }
        Object res = data[pos];
        pos--;
        return res;
    }
}

class myQueue{
    private Object data[];
    private int head=0;
    private int tail=0;
    private int size;
    
    public myQueue(int size)  {
        // TODO Auto-generated constructor stub
        this.size=size;
        data=new Object[size];
    }
    //入队的操作
    public void enqueue(Object object) {
        if(tail==size-1) {
            tail=0;
        }
        data[tail]=object;
        tail++;
    }
    //出队的操作
    public Object dequeue() {
        if (data[head] == null) {
            return null;
        }
        Object res=data[head];
        if (head==size-1)
            head=0;
        head++;
        return res;
    }
    
}
