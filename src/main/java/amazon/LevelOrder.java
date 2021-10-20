package amazon;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, display the node values at each level.
Node values for all levels should be displayed on separate lines. Let’s take a look at the below binary tree.
 */
public class LevelOrder {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        printLevelItem(a);
    }

    // will use 2 queue
    // 1 to hold current level
    // 2 to hold next level and switch them everytime we process
    private static void printLevelItem(Node root) {
        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();

        currentLevel.offer(root);
        StringBuilder levelBuilder = new StringBuilder();
        while (!currentLevel.isEmpty()) {
            Node current = currentLevel.remove();
            levelBuilder.append(current.data).append(" ----> ");

            if (current.left != null) {
                nextLevel.offer(current.left);
            }

            if (current.right != null) {
                nextLevel.offer(current.right);
            }

            if (currentLevel.isEmpty()) {
                System.out.println(levelBuilder.append("null").toString());
                levelBuilder = new StringBuilder();
                Queue<Node> temp = nextLevel;
                nextLevel = currentLevel;
                currentLevel = temp;
            }
        }

    }
}
