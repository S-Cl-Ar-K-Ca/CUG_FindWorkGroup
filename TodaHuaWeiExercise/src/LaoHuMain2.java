/*
* 有序链表剔除重复元素,三支针法
* */
public class LaoHuMain2 {
    public static void main(String[] args) {

    }
    //去掉所有重复，留一个元素
    public static Node getHead(Node head){
        if(null == head || null == head.next){
            return head;
        }
        Node pre = new Node();
        pre.next = head;
        Node newHead = pre;
        Node cur = head;
        Node nex = head.next;
        while (nex!=null){
            while (nex!=null && cur.value == nex.value){
                nex = nex.next;
            }
            if(cur.next!=nex){
                while (cur!=nex){
                    pre.next = cur.next;
                    //delete cur;
                    cur = pre.next;
                }
            }else {
                pre = cur;
                cur = cur.next;
                nex = nex.next;
            }
        }
        newHead = newHead.next;
        return  newHead;
    }
    //去掉所有重复
    public static Node getHead2(Node head){
        if(null == head || null == head.next){
            return head;
        }
        Node pre = new Node();
        pre.next = head;
        Node newHead = pre;
        Node cur = head;
        Node nex = head.next;
        while (nex!=null){
            while (nex!=null && cur.value == nex.value){
                nex = nex.next;
            }
            if(cur.next!=nex){
               pre.next = nex;
               cur = nex;
               nex = nex.next;
            }else {
                pre = cur;
                cur = cur.next;
                nex = nex.next;
            }
        }
        newHead = newHead.next;
        return  newHead;
    }
}
class Node{
    public int value;
    public Node next;
}