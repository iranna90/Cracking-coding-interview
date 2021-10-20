package tree;

public class CheckBinarySearchTree {
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
    System.out.println(isBinarySearchTree(one, Integer.MIN_VALUE, Integer.MAX_VALUE));

    one.left = null;
    one.right = null;
    three.left = null;
    three.right = null;
    two.left = one;
    two.right = three;
    System.out.println(isBinarySearchTree(two, Integer.MIN_VALUE, Integer.MAX_VALUE));

  }

  public static boolean isBinarySearchTree(Node node, int minimum, int maximum) {

    if (node == null) {
      return true;
    }

    if (node.data < minimum || node.data > maximum) {
      return false;
    }

    return isBinarySearchTree(node.left, minimum, node.data)
        && isBinarySearchTree(node.right, node.data, maximum);
  }
}
