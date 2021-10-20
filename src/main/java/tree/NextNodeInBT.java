package tree;

/*
Given a node in BT find next one in in-order traversal.
 */
public class NextNodeInBT {
  public static void main(String[] args) {

  }

  private static Node nextNode(Node node) {
    // left --- root --- right
    if (node.left != null) {
      return node.left;
    }

    return null;
  }
}
