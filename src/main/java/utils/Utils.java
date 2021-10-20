package utils;

import tree.Node;

public class Utils {

    public static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ---> ");
            node = node.next;
        }
        System.out.print("null");
    }
}
