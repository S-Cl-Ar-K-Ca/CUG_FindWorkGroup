
import java.util.Stack;

public class treeNode {
	int data;
	treeNode left;
	treeNode right;
	
	public treeNode(int value) {
		this.data = value;
	}

	//设置左孩子
	public void setLeft(treeNode left) {
		this.left = left;
	}
	//设置右孩子
	public void setRight(treeNode right) {
		this.right = right;
	}
	
	public treeNode getLeft() {
		return left;
	}
	public treeNode getRight() {
		return right;
	}
	
	public int getData() {
		return data;
	}
	
    // 前序遍历 ，递归写法
    public void frontTraversal(treeNode node) {
        if (node != null) {
            System.out.print(node.data+" ");
            frontTraversal(node.left);
            frontTraversal(node.right);
        }
    }

    // 前序遍历，非递归写法，利用stack
    public void frontTraversalNew(treeNode node) {
        Stack<treeNode> stack =new Stack<>();
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                System.out.print(node.data+" ");
                stack.push(node);
                node = node.left;
            }
            if (! stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    //中序遍历 midTraversal，递归写法
    public void midTraversal(treeNode node) {
        if (node != null) {
           midTraversal(node.left);
           System.out.print(node.data+" ");
           midTraversal(node.right);
        }
    }
    //中序遍历，非递归写法，利用stack
    public void midTraversalNew(treeNode node) {
        Stack<treeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }
        }
        
    }
    
    //后序遍历，递归写法
    public void afterTraversal(treeNode node) {
        if (node != null) {
            afterTraversal(node.left);
            afterTraversal(node.right);
            System.out.print(node.data+" ");
        }
    }
    //后序遍历，非递归写法，利用stack两个
    public void afterTraversalNew(treeNode node) {
        Stack<treeNode> stackForNode = new  Stack<>();
        Stack< Integer> stackForState =new Stack<>();
        int state =1;
        while(node != null || !stackForNode.isEmpty()) {
            while(node != null) {
                stackForNode.push(node);
                stackForState.push(0);
                node  = node.left;
            }           
            while(!stackForNode.isEmpty() && stackForState.peek()==state) {
                stackForState.pop();
                //node = stackForNode.pop();
                System.out.print(stackForNode.pop().data+" ");
            }
            if( !stackForNode.isEmpty()) {
                stackForState.pop();
                stackForState.push(1);
                node = stackForNode.peek();
                node = node.right;
            }
        }
        
    }
    
/*	//前序遍历
	public void frontTraversal(treeNode node) {
		//先输出父节点
		System.out.print(node.getData()+" ");
		//再输出左孩子,并对左孩子递归
		if(node.left != null) {
			frontTraversal(node.left);
		}
		//然后输出右孩子，并对右孩子递归
		if(node.right != null) {
			frontTraversal(node.right);
		}
	}
	
	//中序遍历 midTraversal
	public void midTraversal(treeNode node) {
		//先输出左节点
		if(node.left != null ) {
			midTraversal(node.left);
		}
		//输出父节点
		System.out.print(node.data+" ");
		//输出右节点
		if(node.right != null ) {
			midTraversal(node.right);
		}
	}
	
	//后序遍历
	public void afterTraversal(treeNode node) {
		//先输出左节点
		if(node.left != null ) {
			afterTraversal(node.left);
		}
		//再输出右节点
		if(node.right != null ) {
			afterTraversal(node.right);
		}
		//然后输出父节点
		System.out.print(node.data+" ");
	}*/
	
	//前序查找
	public treeNode frontSearch(int data) {
		treeNode res=null;
		//先对根部进行比对
		if (this.data ==data) {
			res=this;
			return res;
		}
		//再对左孩子进行比对
		if(this.left !=null) {
			res=this.left.frontSearch(data);
		}
		if (res!=null) {
			return res;
		}
		//再对右孩子进行比对查找
		if (this.right !=null) {
			res=this.right.frontSearch(data);
		}
		return res;
	}
	
	public treeNode midSearch(int data) {
		treeNode res=null;
		//先对根部进行比对

		//再对左孩子进行比对
		if(this.left !=null) {
			res=this.left.midSearch(data);
		}
		if (res!=null) {
			return res;
		}		
		if (this.data ==data) {
			res=this;
			return res;
		}
		//再对右孩子进行比对查找
		if (this.right !=null) {
			res=this.right.midSearch(data);
		}
		return res;
	}
	
	public treeNode afterSearch(int data) {
		treeNode res=null;
		//再对右孩子进行比对
		if(this.right !=null) {
			res=this.right.afterSearch(data);
		}
		if (res!=null) {
			return res;
		}		
		//再对左孩子进行比对查找
		if (this.left !=null) {
			res=this.left .afterSearch(data);
		}
		if (res!=null) {
			return res;
		}	
		if(this.data!=data) {
			return null;
		}
		return this;
	}

	//删除子树或节点  考察递归！！！
	public void deleteSubTree(int data) {
		treeNode parent =this;	
		//判读左边是要删除的点
		if (parent.left !=null && parent.left.data ==data) {
			parent.left=null;
			return;
		}
		//judge Rigth is 0r not
		if (parent.right !=null && parent.right.data ==data) {
			parent.right=null;
			return;
		}
		
		//递归
		parent=this.left;
		if (parent!=null) {
			parent.deleteSubTree(data);
		}
		parent=this.right;
		if (parent!=null) {
			parent.deleteSubTree(data);
		}
	}
	
	
}
