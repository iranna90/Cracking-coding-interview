package tree;

public class Node {
  public final int data;
  public Node left;
  public Node right;
  public Node parent;

  public Node(final int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return String.valueOf(data);
  }
}
