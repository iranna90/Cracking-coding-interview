package amazon;

import tree.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static utils.Utils.printLinkedList;

/*
You are given a linked list where the node has two pointers.
The first is the regular next pointer. The second pointer is called arbitrary_pointer and it can point to any node in the linked list.
Your job is to write code to make a deep copy of the given linked list. Here,
deep copy means that any operations on the original list should not affect the copied list.
 */
// a -> d and c -> a
// a ---> b ---> c ---> d
public class LinkedListArbitraryPointer {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        a.arbitrary = d;
        b.next = c;
        b.arbitrary = c;
        c.next = d;
        c.arbitrary = a;
        d.arbitrary = b;
        printLinkedList(a);
        System.out.println();
        arbitraryPrint(a);

        Node result = deepCopy(a);

        System.out.println();
        printLinkedList(result);
        System.out.println();
        arbitraryPrint(result);
    }

    private static void arbitraryPrint(Node head) {
        while (head != null) {
            System.out.print(head.arbitrary.data + " ---> ");
            head = head.next;
        }
    }

    private static Node deepCopy(Node list) {
        Node head = null;
        Node current = null;

        Node source = list;

        Map<Node, Node> oldToNewMap = new HashMap<>();
        while (source != null) {
            Node newNode = new Node(source.data);
            if (head == null) {
                head = newNode;
            } else {
                current.next = newNode;
            }
            oldToNewMap.put(source, newNode);
            current = newNode;
            source = source.next;

        }

        source = list;
        current = head;
        while (source != null) {
            current.arbitrary = oldToNewMap.get(source.arbitrary);
            source = source.next;
            current = current.next;
        }

        return head;
    }
}
