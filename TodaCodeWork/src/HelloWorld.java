class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String regex = "\\(.*?\\)";
        String s = "asdfa(sfa)ssfd(sdfa)asd";
        System.out.println(s.replaceAll(regex,"+"));
        int arr[] = new int[5];
        System.out.println(arr[0]);
    }
}

   /*
   判断两个链表是否相交，若相交则找出交点（1）用栈可以做 （2）java中集合类直接可以做 （3）算链表长度差，再遍历 （4）用hashcode
    public node solution(node head1,node head2){
        if (null == head1 || null == head2){
            return null;
        }
        Stack<node> stack1 = new Stack();
        Stack<node> stack2 = new Stack();
        node p1 = head1;
        node p2 = head2;
        while(p1!=null){
            stack1.push(p1);
            p1 = p1.next;
        }
        while(p2!=null){
            stack2.push(p1);
            p2 = p2.next;
        }
        if(stack1.peek != stack2.peek){
            return null;
        }else{
            while(stack1.peek() == stack2.peek()){
                node res = stack1.pop();
                stack2.pop();
            }
            return res;
        }
    }

    判断链表是否存在环
    public boolean Solution2(node head){
        boolean res = false;
        node slow = head;
        node fast = head;

        while(slow.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)){
                return true;
            }
        }

        return false;
    }*/