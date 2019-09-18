import Datastruct.treeNode;

public class ReBuildBinaryTree {
    public treeNode reBuildBinaryTree(int forntOrder[],int midOrder[]){
        if(null == forntOrder || null == midOrder){
            return null;
        }
        treeNode root = reBuildBinaryTreeCore(forntOrder,0,forntOrder.length-1,midOrder,0,midOrder.length-1);
    }

    public treeNode reBuildBinaryTreeCore(int forntOrder[],int forntStart,
                                          int forntEnd,int midOrder[],int midStart,int midEnd){
        if(forntStart>forntEnd || midStart>midEnd){
            return null;
        }
        treeNode root = new treeNode(forntOrder[forntStart]);
        for(int i = forntStart; i <= forntEnd;i++){
            if(midOrder[i] == forntOrder[forntStart]){
                root.left = reBuildBinaryTreeCore(forntOrder,forntStart+1,forntStart+(i-midStart),
                        midOrder,midStart,i-1);
                root.right = reBuildBinaryTreeCore(forntOrder,forntStart+(i-midStart)+1,forntEnd,midOrder,i+1,midEnd);
            }
        }
        return  root;
    }
}
