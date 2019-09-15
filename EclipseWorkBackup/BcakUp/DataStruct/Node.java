
public class Node {
		int vlaue;
		Node next;	
		//构造函数
		public Node(int value) {
			this.vlaue = value;
		}	
		//输出节点中的数值
		public int getValue() {
			return this.vlaue;
		}
		//找下一个节点
		public Node getNext() {
			return this.next;
		}
		
		//在链表的最后插入节点
		public void append(Node node) {
			Node curNode= this;
		
			while(curNode.next != null) {
				curNode =curNode.next;
			}	
			if (curNode.next==null) {
				curNode.next = node;
			}
		}
		
		//判断节点是否为最后一个节点
		public boolean isLast() {
			return this.next==null;
		}
		
	   //假如此刻指向链表头，展示往后所有节点信息
		public void show() {
			Node curNode =this;
			while(true) {
				if (curNode !=null) {
					System.out.print(curNode.vlaue+" ");
					curNode = curNode.next;
				}else  break;
			}
		}
		
		//删除当前节点的下一个节点
		public void removeNext() {
			Node curNode = this;
			if(curNode.next.next != null) {
				curNode.next= curNode.next.next;
			}else {
				curNode.next =null;
			}
		}
		
		//在当前节点后面插入一个新节点
		public void insertNode(Node node) {
			Node curNode = this;
			if (curNode.next == null) {
				curNode.next = node;
			}else {
				node.next = curNode.next;
				curNode.next=node;
			}
		}
		
		//使用递归，倒序输出链表
		public void reversePrint(Node node) {
			if (node.next == null ) {
				System.out.print(node.getValue()+" ");
				return;
			}
			reversePrint(node.next);
			System.out.print(node.getValue()+" ");
		}
		
		//使用递归，实现链表的反转	
		/** https://blog.csdn.net/guyuealian/article/details/51119499
		 * @param head  当前链表的头结点
		 * @return
		 */
		public Node reverseLink(Node head) {
		    if (head == null || head.next == null) {
		        return head;
		    }
		    Node newHead = reverseLink(head.next);
		    head.next.next = head;
		    head.next=null;
		    return newHead;
		}
		
}
