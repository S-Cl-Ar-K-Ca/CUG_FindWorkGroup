
public class BinaryTtest {
	public static void main(String[] args) {
		treeNode root =new treeNode(1);
		treeNode n1 =new treeNode(2);
		treeNode n2 =new treeNode(3);
		treeNode n3 =new treeNode(4);
		treeNode n4 =new treeNode(5);
		treeNode n5 =new treeNode(6);
		treeNode n6 =new treeNode(7);
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);n1.setRight(n4);n2.setLeft(n5);n2.setRight(n6);
		BinaryTree bTree =new BinaryTree(root);
		System.out.println("两种前序遍历");
		bTree.frontTraversal();
		System.out.println();
		bTree.frontTraversalNew();
		
		System.out.println();
		System.out.println("两种中序遍历");
		bTree.midTraversal();
		System.out.println();
		bTree.midTraversalNew();
		
		System.out.println();
		System.out.println("两种后序遍历");
		bTree.afterTraversal();
		System.out.println();
		bTree.afterTraversalNew();
		
/*		//调用二叉树的查找方法
		System.out.println();
		System.out.println(root.equals(bTree.afterSearch(0)));;
		System.out.println(bTree.afterSearch(6));*/
		
		bTree.deleteSubTree(0);
		System.out.println();
		bTree.frontTraversal();
/*		root.setLeft(n1);
		root.setRight(n2);	
		n2.setRight(n3);
		System.out.println(bTree.getRoot().getRight().getRight().getData());*/
		
	}
}
