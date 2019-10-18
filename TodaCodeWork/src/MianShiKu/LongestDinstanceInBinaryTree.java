package MianShiKu;

public class LongestDinstanceInBinaryTree {
    public int longest;
    public void getLongestDinstanse(TreeNode root){
        if(null == root){
            return;
        }
        if(null == root.left){
            root.leftLongest = 0;
        }
        if(null == root.right){
            root.rightLongest = 0;
        }
        if(root.left != null){
            getLongestDinstanse(root.left);
        }
        if(root.right != null){
            getLongestDinstanse(root.right);
        }
        if(root.left!=null){
            root.leftLongest = Math.max(root.left.leftLongest,root.left.rightLongest)+1;
        }
        if(root.right!=null){
            root.rightLongest = Math.max(root.right.leftLongest,root.right.rightLongest)+1;
        }
        longest = Math.max(root.leftLongest+root.rightLongest,longest);
    }

}
class TreeNode{
    int value;
    public TreeNode left;
    public TreeNode right;
    public int leftLongest;
    public int rightLongest;
}
