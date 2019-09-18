import Datastruct.treeNode;

public class LeetCode236 {
    public treeNode lowestConmmonFather(treeNode root,treeNode node1,treeNode node2){
        if(null == root){
            return root;
        }
        if(root == node1 || root == node2){
            return root;
        }
        treeNode left = lowestConmmonFather(root.getLeft(),node1,node2);
        treeNode right = lowestConmmonFather(root.getRight(),node1,node2);
        if(left != null && right !=null){
            return root;
        }else if(left != null){
            return left;
        }else if(right != null){
            return right;
        }
        return null;
    }
}
