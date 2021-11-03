package graphs;

import tree.Node;

public class CommonParent {

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
  // but
}
