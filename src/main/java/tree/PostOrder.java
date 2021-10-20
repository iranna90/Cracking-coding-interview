package tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PostOrder {

  public static void main(String[] args) {
    // build tree
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

    recursive(one);
    System.out.println("=================================");
    iterative(one);
  }

  private static void recursive(Node root) {
    if (root == null) {
      return;
    }

    recursive(root.left);
    recursive(root.right);
    System.out.println(root.data);
  }

  private static void iterative(Node root) {
    if (root == null) {
      return;
    }

    Stack<Node> nextNodeVisiting = new Stack<>();
    Set<Node> visited = new HashSet<>();
    nextNodeVisiting.push(root);
    while (!nextNodeVisiting.isEmpty()) {

      Node nextNode = nextNodeVisiting.peek();

      // go left
      while (nextNode.left != null && !visited.contains(nextNode.left)) {
        nextNodeVisiting.push(nextNode.left);
        nextNode = nextNode.left;
      }

      if (nextNode.right != null && !visited.contains(nextNode.right)) {
        nextNodeVisiting.push(nextNode.right);
        continue;
      }

      Node current = nextNodeVisiting.pop();
      System.out.println(current.data);
      visited.add(current);
    }
  }

}
