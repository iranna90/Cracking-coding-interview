package tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class InOrder {

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

    recursiveTraverse(one);
    System.out.println("=================================");
    iterative(one);
  }

  private static void recursiveTraverse(Node root) {
    if (root == null) {
      return;
    }

    recursiveTraverse(root.left);
    System.out.println(root.data);
    recursiveTraverse(root.right);
  }

  private static void iterative(Node root) {
    Stack<Node> nodesToBeVisited = new Stack<>();
    nodesToBeVisited.push(root);
    Set<Node> visited = new HashSet<>();
    while (!nodesToBeVisited.isEmpty()) {

      // go left until we are done
      Node nextNode = nodesToBeVisited.peek();

      while (nextNode.left != null && !visited.contains(nextNode.left)) {
        nodesToBeVisited.push(nextNode.left);
        nextNode = nextNode.left;
      }

      // top element on the stack is leftmost leaf node
      Node currentRoot = nodesToBeVisited.pop();
      System.out.println(currentRoot.data);
      visited.add(currentRoot);

      // check right
      if (currentRoot.right != null && !visited.contains(currentRoot.right)) {
        nodesToBeVisited.push(currentRoot.right);
      }
    }
  }
}
