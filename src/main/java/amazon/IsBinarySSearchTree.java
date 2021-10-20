package amazon;

import tree.Node;

// also can be done by first doing inorder traversla and then check the result is sorted
public class IsBinarySSearchTree {
    public static void main(String[] args) {

    }

    private static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
}
