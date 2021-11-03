package graphs;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelPrint {

    public static void print(Node root) {
        Queue<Node> nextLevel = new LinkedList<>();
        Queue<Node> currentLevel = new LinkedList<>();
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Node node = currentLevel.remove();
            System.out.print(node.data+"   ");
            if (node.left != null) {
                nextLevel.add(node.left);
            }

            if (node.right != null) {
                nextLevel.add(node.right);
            }

            // switch current and next
            if (currentLevel.isEmpty()) {
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }
    }
}
