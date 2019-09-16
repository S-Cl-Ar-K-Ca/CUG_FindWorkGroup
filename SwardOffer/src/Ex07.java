import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
* 用两个栈实现一个队列 , 以及两个队列实现一个栈
* */
public class Ex07 {
}
class MyQueue{
    private Stack<Object> stack1;
    private Stack<Object> stack2;

    public void push(int a){
        stack1.push(a);
    }

    public Object pop(){
        if(stack2.isEmpty() && stack1.isEmpty()){
            return null;
        }
         if(stack2.isEmpty()){
             while (!stack1.isEmpty()){
                 stack2.push(stack1.pop());
             }
         }
         return stack2.pop();
    }
}

class MyStack{
    private LinkedList<Object> queue1 = new LinkedList<>();
    private LinkedList<Object> queue2 = new LinkedList<>();

    public void push(Object e){
        if(queue1.size()==0 && queue2.size()==0){
            queue1.addLast(e);
        }else if(queue1.size()!=0){
            queue1.addLast(e);
        }else if(queue2.size()!=0){
            queue2.addLast(e);
        }
    }

    public Object pop() throws Exception {
        Object e = null;
        if(queue2.size()==0 && queue1.size()==0){
            throw new Exception("Stack is empty");
        }
        if(queue2.size()==0){
            while (queue1.size()>0){
                e = queue1.removeFirst();
                if(queue1.size()!=0){
                    queue2.addLast(e);
                }
            }
        }else if(queue1.size()==0){
            while (queue2.size()>0){
                e = queue2.removeFirst();
                if(queue2.size()!=0){
                    queue1.addLast(e);
                }
            }
        }
        return e;
    }
}