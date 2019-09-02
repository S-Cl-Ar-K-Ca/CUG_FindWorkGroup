package Datastruct;

public class FindKthNode {
    public static void main(String[] args) {

    }

    /*
    * 找出单向链表中倒数第K个节点，用两个指针来做，pre 和 nex之间相隔K-1即可
    * 但是在Java中直接有linkedlist可以使用，其是双向链表
    * */
 /*   public Node findKthNode(int k){
        if(k < 1 || k > linkedList.size){
            return null;
        }
        node pre = first;// 头结点
        node nex = first;
        for(int i=1;i < k;i++){
            nex = nex.next;
        }
        while(nex.next!=null){
            nex = nex.next;
            pre = pre.next;
        }
        return pre;
    }*/
}
