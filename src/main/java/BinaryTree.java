public class BinaryTree {

    BinaryTreeNode root;

    public boolean isBlanced(BinaryTreeNode binaryTreeNode) {

        if(binaryTreeNode == null) return true;

        return Math.abs(height(binaryTreeNode.left) - height(binaryTreeNode.right)) <= 1 && isBlanced(binaryTreeNode.left) && isBlanced(binaryTreeNode.right);
    }

    public int height(BinaryTreeNode binaryTreeNode) {

        if(binaryTreeNode == null) return 0;

        return 1 + Math.max(height(binaryTreeNode.left), height(binaryTreeNode.right));
    }
}
