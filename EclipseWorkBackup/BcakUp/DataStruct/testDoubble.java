

public class testDoubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doubbleNode n1=new doubbleNode(1);
		doubbleNode n2=new doubbleNode(2);
		doubbleNode n3=new doubbleNode(3);
		
		n1.insert(n2);
		n2.insert(n3);
		n1.print();
		
		System.out.println();
		System.out.println(n1.getData());
		System.out.println(n1.pre.getData());
		System.out.println(n1.pre.pre.getData());
		


	}
	

}
