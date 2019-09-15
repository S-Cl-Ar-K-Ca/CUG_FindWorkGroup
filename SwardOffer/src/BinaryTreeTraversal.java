import java.util.Stack;

public class BinaryTreeTraversal {
    //前序遍历,递归写法
    public void frontTraversal(Node node){
        if(node!=null){
            System.out.println(node.value);
            frontTraversal(node.left);
            frontTraversal(node.right);
        }
    }
    //前序遍历，非递归写法
    public void frontTraversalStack(Node node){
        Stack<Node> stackForNode = new Stack<>();
        while (node!=null || !stackForNode.isEmpty()){
            while (node!=null){
                System.out.println(node.value);
                stackForNode.push(node);
                node = node.left;
            }
            if(!stackForNode.isEmpty()){
                stackForNode.pop();
                node = node.right;
            }
        }
    }

    //中序遍历，递归写法
    public void midTraversal(Node node){
        if(node!=null){
            midTraversal(node.left);
            System.out.println(node.value);
            midTraversal(node.right);
        }
    }

    //中序遍历，非递归写法
    public void midTraversalStack(Node node){
        Stack<Node> stackForNode = new Stack<>();
        while (node!=null || !stackForNode.isEmpty()){
            while (node!=null){
                stackForNode.push(node);
                node = node.left;
            }
            if(!stackForNode.isEmpty()){
                node = stackForNode.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    //后序遍历，递归写法
    public void afterTraversal(Node node){
        if(node!=null){
            afterTraversal(node.left);
            afterTraversal(node.right);
            System.out.println(node.value);
        }
    }
    //后续遍历，非递归写法
    public void afterTracersal(Node node){
        Stack<Node> stackForNode =new Stack<>();
        Stack<Integer> stackForState = new Stack<>();
        int state = 1;
        while (node!=null||!stackForNode.isEmpty()){
            while (node!=null){
                stackForNode.push(node);
                stackForState.push(0);
                node = node.left;
            }
            while (!stackForNode.isEmpty() && stackForState.peek()==state){
                stackForState.pop();
                System.out.println(stackForNode.pop().value);
            }
            if(!stackForNode.isEmpty()){
                stackForState.pop();
                stackForState.push(1);
                node = stackForNode.peek();
                node = node.right;
            }
        }
    }
}

class Node{
    public  int value;
    public Node left;
    public Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}