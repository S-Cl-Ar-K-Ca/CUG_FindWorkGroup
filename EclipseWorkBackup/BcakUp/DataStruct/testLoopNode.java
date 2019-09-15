

public class testLoopNode {

	public static void main(String[] args) {
		loopNode n1 = new loopNode(1);
		loopNode n2 = new loopNode(2);
		loopNode n3 = new loopNode(3);
		loopNode n4 = new loopNode(4);
		
		n1.insertNode(n2);
		n2.insertNode(n3);
		n3.insertNode(n4);
		n1.print();

	}
}
