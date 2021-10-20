package tree;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given directed graph find is there a route between 2 nodes or not
 */
public class RouteBetweenNodes {

  public static void main(String[] args) {
    GraphNode four = new GraphNode(4, Collections.emptyList());
    GraphNode three = new GraphNode(3, Collections.singletonList(four));
    GraphNode two = new GraphNode(2, Collections.singletonList(three));
    GraphNode one = new GraphNode(1, Stream.of(two, four).collect(Collectors.toList()));

    System.out.println(isThereAPath(two, one));
  }

  public static boolean isThereAPath(GraphNode source, GraphNode destination) {
    Set<GraphNode> visited = new HashSet<>();
    Queue<GraphNode> queue = new LinkedList<>();
    queue.add(source);
    while (!queue.isEmpty()) {

      GraphNode node = queue.remove();
      if (node.data == destination.data) {
        return true;
      }

      visited.add(node);

      for (GraphNode child : node.nodes) {
        if (!visited.contains(child)) {
          queue.add(child);
        }
      }
    }

    return false;
  }
}
