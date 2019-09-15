/*
* 输入一个链表的头结点，请逆向打印该链表
* */
public class Ex05 {
    public static void resversePrint(LinkecNode head){
        if(head!=null){
            if(head.next!=null){
                resversePrint(head.next);
            }
            System.out.print(head.value);
        }
    }

}

class LinkecNode{
    public int value;
    public LinkecNode next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkecNode getNext() {
        return next;
    }

    public void setNext(LinkecNode next) {
        this.next = next;
    }
}