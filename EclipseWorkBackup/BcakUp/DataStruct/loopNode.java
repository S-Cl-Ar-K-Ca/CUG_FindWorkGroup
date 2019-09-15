public class loopNode {
		int vlaue;
		loopNode next = this;	//循环链表
		//构造函数
		public loopNode(int value) {
			this.vlaue = value;
		}	
		//输出节点中的数值
		public int getValue() {
			return this.vlaue;
		}
		//找下一个节点
		public loopNode getNext() {
			return this.next;
		}
		
		
		//删除当前节点的下一个节点
		public void removeNext() {
			loopNode curNode = this;
			if(curNode.next.next != null) {
				curNode.next= curNode.next.next;
			}else {
				curNode.next =null;
			}
		}
		
		//在当前节点后面插入一个新节点
		public void insertNode(loopNode node) {
			loopNode curNode = this;
			if (curNode.next == null) {
				curNode.next = node;
			}else {
				node.next = curNode.next;
				curNode.next=node;
			}
		}
		
		//打印单向循环链表
		public void print() {
			loopNode mark = this;
			loopNode curNode = this;
			while(true) {
				if (curNode.next== mark) {
					System.out.print(curNode.vlaue+" ");
					return;
				}else {					
					System.out.print(curNode.vlaue+" ");
					curNode=curNode.next;
				}
			}
		}
}
