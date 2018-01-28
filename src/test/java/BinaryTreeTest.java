import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    @Test
    public void isBlanced_return_true_if_tree_is_balanced() {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        tree.root.right = new BinaryTreeNode(6);
        tree.root.right.left = new BinaryTreeNode(5);
        tree.root.right.right = new BinaryTreeNode(7);

        assertTrue(tree.isBlanced(tree.root));
    }

    @Test
    public void isBlanced_return_true_if_there_is_one_difference() {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        tree.root.right = new BinaryTreeNode(6);
        tree.root.right.left = new BinaryTreeNode(5);
        tree.root.right.right = new BinaryTreeNode(7);
        tree.root.right.right = new BinaryTreeNode(9);

        assertTrue(tree.isBlanced(tree.root));
    }

    @Test
    public void isBlanced_return_false_if_tree_not_balanced() {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        tree.root.right = new BinaryTreeNode(6);
        tree.root.right.right = new BinaryTreeNode(8);
        tree.root.right.right.right = new BinaryTreeNode(9);
        tree.root.right.right.right.right = new BinaryTreeNode(15);

        assertFalse(tree.isBlanced(tree.root));
    }
}