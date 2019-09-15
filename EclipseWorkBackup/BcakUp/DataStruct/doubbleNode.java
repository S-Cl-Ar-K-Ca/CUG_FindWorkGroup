

public class doubbleNode {
		doubbleNode pre =this;
		int data;
		doubbleNode next = this;
		
		public doubbleNode(int value) {
			this.data = value;
		}
		//获取下一个节点
		public doubbleNode next() {
			return this.next;
		}
		
		//获取上一个节点
		public doubbleNode pre() {
			return this.pre;
		}
		//获取当前节点的数据
		public int getData() {
			return this.data;
		}
		//插入一个节点
		public void insert(doubbleNode node) {
			doubbleNode curNode = this;
			doubbleNode curNext = this.next;
			//插入节点
			curNode.next=node;
			node.pre=curNode;
			
			node.next=curNext;
			curNext.pre=node;
		}
		
		//打印单向循环链表
		public void print() {
			doubbleNode mark = this;
			doubbleNode curNode = this;
			while(true) {
				if (curNode.next== mark) {
					System.out.print(curNode.data+" ");
					return;
				}else {					
					System.out.print(curNode.data+" ");
					curNode=curNode.next;
				}
			}
		}
}
