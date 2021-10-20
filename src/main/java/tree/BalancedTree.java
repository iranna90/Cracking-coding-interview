package tree;

public class BalancedTree {
  public static void main(String[] args) {
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
    System.out.println(isBalancedTree(one));

    two.right = seven;;
    System.out.println(isBalancedTree(one));

    one.right = null;
    System.out.println(isBalancedTree(one));
  }

  private static boolean isBalancedTree(Node node) {
    if (node == null) {
      return true;
    }

    int maxHeight = maxHeight(node);
    int minHeight = minHeight(node);
    System.out.println("Max height " + maxHeight + " minimum height " + minHeight);
    return maxHeight - minHeight <= 1;
  }

  private static int minHeight(final Node node) {
    if (node == null) {
      return 0;
    }

   /* if (node.right == null && node.left == null) {
      return 1;
    }

    if (node.right == null) {
      return 1+ minHeight(node.left);
    }

    if (node.left == null) {
      return 1 + minHeight(node.right);
    }*/

    int minHeightFromLeftTree = 1 + minHeight(node.left);
    int minHeightFromRightTree = 1 + minHeight(node.right);
    return Math.min(minHeightFromLeftTree, minHeightFromRightTree);
  }

  private static int maxHeight(final Node node) {
    if (node == null) {
      return 0;
    }

    int maxHeightFromLeftTree = 1 + maxHeight(node.left);
    int maxHeightFromRightTree = 1 + maxHeight(node.right);
    return Math.max(maxHeightFromLeftTree, maxHeightFromRightTree);
  }


}
