import java.util.List;

public class LeetCode19 {
    public ListNode deleteKNode(ListNode head,int k){
        if(null == head ){
            return null;
        }
        ListNode pre = head;
        ListNode nex = head;
        while (k>0){
            nex = nex.next;
        }
        while (nex.next!=null){
            nex = nex.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}