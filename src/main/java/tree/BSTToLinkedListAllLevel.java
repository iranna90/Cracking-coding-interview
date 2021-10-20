package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
GIven binary tree create a linked list at all the level
 */
public class BSTToLinkedListAllLevel {
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

    for (LinkedList<Node> result : linkedLists(one)) {
      System.out.println(result);
    }
  }

  private static List<LinkedList<Node>> linkedLists(final Node root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<LinkedList<Node>> result = new ArrayList<>();
    Queue<NodeWithLevel> nextNodesToBeProcessed = new LinkedList<>();
    Set<Node> visited = new HashSet<>();

    nextNodesToBeProcessed.add(new NodeWithLevel(0, root));
    while (!nextNodesToBeProcessed.isEmpty()) {
      NodeWithLevel nodeWithLevel = nextNodesToBeProcessed.remove();

      // already this level list exists
      if (nodeWithLevel.level < result.size()) {
        result.get(nodeWithLevel.level).add(nodeWithLevel.node);
      } else {
        LinkedList<Node> list = new LinkedList<>();
        list.add(nodeWithLevel.node);
        result.add(list);
      }

      // get the children of this node and add it to the +
      if (nodeWithLevel.node.left != null && !visited.contains(nodeWithLevel.node.left)) {
        nextNodesToBeProcessed.add(new NodeWithLevel(nodeWithLevel.level + 1, nodeWithLevel.node.left));
      }

      if (nodeWithLevel.node.right != null && !visited.contains(nodeWithLevel.node.right)) {
        nextNodesToBeProcessed.add(new NodeWithLevel(nodeWithLevel.level + 1, nodeWithLevel.node.right));
      }

      visited.add(nodeWithLevel.node);
    }

    return result;
  }

  private static class NodeWithLevel {
    private final int level;
    private final Node node;

    private NodeWithLevel(final int level, final Node node) {
      this.level = level;
      this.node = node;
    }
  }
}
