package linked;

import java.util.HashSet;
import java.util.Set;

/*
Write code to remove duplicates from an unsorted linked list

FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        n1.next = n2;
        Node n3 = new Node(2);
        n2.next = n3;
        Node n4 = new Node(3);
        n3.next = n4;
        printList(n1);
        removeDuplicate(n1);
        System.out.println();
        printList(n1);
    }

    private static void printList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }

        System.out.print("null");
    }

    private static void removeDuplicate(Node head) {
        Set<Integer> processed = new HashSet<>();
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (processed.contains(current.data)) {
                previous.next = current.next;
            } else {
                processed.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    /*
    Without buffer use 2 loops
    outer one goes from head to last
    inner one goes from head to previous-current
     */
}
