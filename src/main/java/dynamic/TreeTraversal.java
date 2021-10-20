package dynamic;

import java.util.Queue;

public class TreeTraversal {

    public static void main(String[] args) {

    }

    private static class Node {
        private final int data;
        private final Node rightChild;
        private final Node leftChild;
        private final Node parent;

        private Node(int data, Node rightChild, Node leftChild, Node parent) {
            this.data = data;
            this.rightChild = rightChild;
            this.leftChild = leftChild;
            this.parent = parent;
        }

        public int getData() {
            return data;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getParent() {
            return parent;
        }
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.leftChild);
        System.out.println(" " + node.data);
        inOrder(node.rightChild);
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(" " + node.data);
        inOrder(node.leftChild);
        inOrder(node.rightChild);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.leftChild);
        inOrder(node.rightChild);
        System.out.println(" " + node.data);
    }

    private static void breadthFirst(Queue<Node> nodes) {
        if (nodes.isEmpty()) {
            return;
        }

        Node node = nodes.element();
        System.out.println(" " + node.data);
        if (node.leftChild != null) {
            nodes.add(node.leftChild);
        }

        if (node.rightChild != null) {
            nodes.add(node.rightChild);
        }

        breadthFirst(nodes);
    }

    private static void breadthFirstLinear(Queue<Node> nodes) {
        while (!nodes.isEmpty()) {
            Node node = nodes.element();
            System.out.println(" " + node.data);
            if (node.leftChild != null) {
                nodes.add(node.leftChild);
            }

            if (node.rightChild != null) {
                nodes.add(node.rightChild);
            }
        }
    }
}
