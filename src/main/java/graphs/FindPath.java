package graphs;

import java.util.ArrayList;
import java.util.List;

import tree.Node;

public class FindPath {
  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);

    two.left = four;
    two.right = five;
    one.left = two;
    one.right = three;

    List<Node> path = new ArrayList<>();
    System.out.println(path(one, five, path));
    System.out.println(path);

    path = new ArrayList<>();
    System.out.println(path(one, six, path));
    System.out.println(path);
  }

  private static boolean path(Node root, Node dest, List<Node> path) {
    if (root == null) {
      return false;
    }

    path.add(root);

    if (root == dest) {
      return true;
    }

    if (path(root.left, dest, path) || path(root.right, dest, path)) {
      return true;
    }

    path.remove(root);
    return false;
  }
}
