package graphs;

import tree.Node;

public class SubTree {
  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    two.left = four;
    two.right = five;
    one.left = two;
    one.right = three;

    Node two2 = new Node(2);
    Node four2 = new Node(4);
    Node five2 = new Node(5);
    two2.left = four2;
    two2.right = five2;

    System.out.println(subTree(one, two2));

    four2.left = new Node(6);
    System.out.println(subTree(one, two2));
  }

  private static boolean subTree(Node t1, Node t2) {
    if (t1 == null) {
      return false;
    }

    if (t1.data == t2.data && treeMatch(t1, t2)) {
      return true;
    }

    return subTree(t1.left, t2) || subTree(t1.right, t2);
  }

  private static boolean treeMatch(final Node t1, final Node t2) {
    if (t1 == null && t2 == null) {
      return true;
    }

    if (t1 == null || t2 == null) {
      return false;
    }

    if (t1.data != t2.data) {
      return false;
    }

    return treeMatch(t1.left, t2.left) && treeMatch(t1.right, t2.right);
  }
}
