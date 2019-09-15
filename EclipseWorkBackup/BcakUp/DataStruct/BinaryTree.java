

public class BinaryTree {
	treeNode root;//定义根节点
	
	//构造函数
	public BinaryTree(treeNode root) {
		this.root =root ;
	}
	
	public treeNode getRoot() {
		return root;
	}
	
	//前序遍历
	public void frontTraversal() {
		if (root !=null) {
				this.root.frontTraversal(root);
		}
	
	}
	//前序遍历,非递归
	 public void frontTraversalNew() {
	        if (root !=null) {
	                this.root.frontTraversalNew(root);
	        }
	    
	    }
	//中序遍历
	public void midTraversal() {
		if (root !=null) {
					this.root.midTraversal(root);;
		}

	}
	   //中序遍历，非递归
    public void midTraversalNew() {
        if (root !=null) {
                    this.root.midTraversalNew(root);;
        }

    }
	//后序遍历
    public void afterTraversal() {
		if (root !=null) {
		    this.root.afterTraversal(root);
		}
    }
    
    public void afterTraversalNew() {
        if (root != null) {
            this.root.afterTraversalNew(root);
        }
	}
	//前序查找
	public treeNode frontSearch(int data) {
		return root.frontSearch(data);
	}
	//中序查找
	public treeNode midSearch(int data) {
		return root.midSearch(data);
	}
	public treeNode afterSearch(int data) {
		return root.afterSearch(data);
	}
	
	//删除子树 *******比较重要
	public void deleteSubTree(int data) {
		if (root.data == data) {
			root=null;
			return;
		}
		root.deleteSubTree(data);
	}
}
