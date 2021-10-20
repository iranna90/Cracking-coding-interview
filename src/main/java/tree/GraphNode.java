package tree;

import java.util.List;

public class GraphNode {
  public final int data;
  public final List<GraphNode> nodes;

  public GraphNode(final int data,
                   final List<GraphNode> nodes) {
    this.data = data;
    this.nodes = nodes;
  }
}
