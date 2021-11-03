package graphs;

import tree.GraphNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Path {
    public static void main(String[] args) {
        GraphNode four = new GraphNode(4, Collections.emptyList());
        GraphNode three = new GraphNode(3, Collections.singletonList(four));
        GraphNode two = new GraphNode(2, Collections.singletonList(three));
        GraphNode one = new GraphNode(1, Stream.of(two, four).collect(Collectors.toList()));

        System.out.println(path(two, one));
    }


    private static boolean path(GraphNode source, GraphNode dest) {
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> nextToProcess = new LinkedList<>();
        nextToProcess.add(source);

        while (!nextToProcess.isEmpty()) {
            GraphNode node = nextToProcess.remove();
            if (node == null) {
                continue;
            }

            visited.add(node);

            if (node == dest) {
                return true;
            }

            List<GraphNode> neighbourNodes = node.nodes;
            for (GraphNode nNode : neighbourNodes) {
                if (!visited.contains(nNode)) {
                    nextToProcess.add(nNode);
                }
            }
        }

        return false;
    }
}
