package graphs;

import tree.Node;

public class CommonParent {

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

    System.out.println(cp(one, four, five));
    System.out.println(cp(one, four, six));
    System.out.println(cp(one, four, three));
  }

  // binary search tree
  /*
  As the tree is BST, to have common parent each node needs to be in child of the on node.
  Means one node has to be on the left side and other node has to be on the right side.
  We need to find this node, and it is easy to find such node as
   */
  private static Node commonParent(Node root, Node a, Node b) {

    int min = Math.min(a.data, b.data);
    int max = Math.max(a.data, b.data);
    while (root != null) {
      if (max > root.data && min < root.data) {
        return root;
      }

      // go right
      if (min > root.data) {
        root = root.right;
      }

      if (max < root.data) {
        root = root.left;
      }
    }

    return null;
  }

  // if not BST
  // but if the node has access to parent then we can check all
  // the parent hirarchy from each node and find first occurrence of each.

  /*
  No access to parent then we need to
   */
  private static Node cp(Node root, Node a, Node b) {

    if (!covers(root, a) || !covers(root, b)) {
      return null;
    }

    return common(root, a, b);
  }

  private static Node common(final Node root, final Node a, final Node b) {

    if (covers(root.left, a) && covers(root.left, b)) {
      return common(root.left, a, b);
    }

    if (covers(root.right, a) && covers(root.right, b)) {
      return common(root.right, a, b);
    }

    return root;
  }

  private static boolean covers(Node root, Node t) {
    if (root == null) {
      return false;
    }

    if (root == t) {
      return true;
    }

    return covers(root.left, t) || covers(root.right, t);
  }

}
