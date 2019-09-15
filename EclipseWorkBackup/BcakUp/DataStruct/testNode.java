

public class testNode {

	public static void main(String[] args) {
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		
		System.out.println(n1.getValue());
		
		//添加节点
		n1.append(n2);
		n1.append(n3);
		n2.append(n4);
		n1.show();
		System.out.println();
		n1.reversePrint(n1);
		
/*		//检查是否添加上
		System.out.println(n1.next.getValue());
		System.out.println(n1.next.next.getValue());
		System.out.println(n2.next.getValue());
		System.out.println(n2.next.next.getValue());*/
		
/*		//删除节点4
		System.out.println();
		n3.removeNext();
		n1.show();*/
		
/*		//删除节点2
		System.out.println();
		n1.removeNext();
		n1.show();*/
		
/*		//在节点1后面插入节点5
		System.out.println();
		Node  n5=new Node(5);
		n1.insertNode(n5);
		n1.show();*/
		
/*		//在节点4后面插入节点6
		System.out.println();
		Node  n6=new Node(6);
		n4.insertNode(n6);
		n1.show();
*/
	}

}
