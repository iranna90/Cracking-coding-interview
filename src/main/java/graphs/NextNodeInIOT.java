package graphs;

import tree.Node;

public class NextNodeInIOT {

  private static Node getNext(Node currentNode) {
    if (currentNode == null) {
      return null;
    }

    // has right
    if (currentNode.right != null) {
      // print left most
      return printLeftMost(currentNode.right);
    }

    // no right
    while (currentNode.parent != null) {
      Node parent = currentNode.parent;
      if (parent.left == currentNode) {
        return parent;
      }
      currentNode = currentNode.parent;
    }

    return null;
  }

  private static Node printLeftMost(Node node) {
    while (node.left != null) {
      node = node.left;
    }

    return node;
  }
}
