package basic;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TraversalWithoutRecursion {
  public static void main(String[] args) {
    Node lr = new Node(4, null, null);
    Node ll = new Node(3, null, null);
    Node rl = new Node(6, null, null);
    Node rr = new Node(7, null, null);
    Node l = new Node(2, ll, lr);
    Node r = new Node(5, rl, rr);
    Node root = new Node(1, l, r);
    inorderRecursive(root);
    System.out.println("iterative");
    inorderIterative(root);
  }

  private static void inorderRecursive(Node root) {
    if (root == null) {
      return;
    }

    inorderRecursive(root.left);
    System.out.println(root.data);
    inorderRecursive(root.right);
  }

  private static void inorderIterative(Node root) {
    Stack<Node> items = new Stack<>();
    Set<Node> processed = new HashSet<>();
    items.push(root);
    while (!items.isEmpty()) {
      Node node = items.peek();
      // check left and continue
      if (node.left != null && !processed.contains(node.left)) {
        items.add(node.left);
        continue;
      }

      // root node and is not already processed
      if (!processed.contains(node)) {
        System.out.println(node.data);
        processed.add(node);
        items.pop();
        if (node.right != null && !processed.contains(node.right)) {
          items.push(node.right);
        }
      }
    }
  }

  // minimum of child and then root and remaining
  private static void process(Node root) {
    if (root == null) {
      return;
    }

    if (root.left == null) {
      process(root.right);
    }


  }
  private static class Node {
    private final int data;
    private final Node left;
    private final Node right;

    private Node(final int data, final Node left, final Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
}
