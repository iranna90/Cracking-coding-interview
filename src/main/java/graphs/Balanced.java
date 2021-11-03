package graphs;

import tree.Node;

public class Balanced {
    public static void main(String[] args) {
        Node five = new Node(5);
        Node four = new Node(4);
        four.right = five;

        Node two = new Node(2);
        two.left = four;

        Node seven = new Node(7);
        Node six = new Node(6);
        Node three = new Node(3);
        three.left = seven;
        three.right = six;

        Node one = new Node(1);
        one.left = two;
        one.right = three;
        System.out.println(isBalanced(one));

        two.right = seven;;
        System.out.println(isBalanced(one));

        one.right = null;
        System.out.println(isBalanced(one));
    }

    private static boolean isBalanced(Node root) {
        int minHeight = getMinHeight(root);
        int maxHeight = getMaxHeight(root);
        return maxHeight - minHeight <= 1;
    }

    private static int getMaxHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getMaxHeight(root.right), getMaxHeight(root.left));
    }

    private static int getMinHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.min(getMinHeight(root.right), getMinHeight(root.left));
    }
}
