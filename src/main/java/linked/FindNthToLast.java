package linked;

public class FindNthToLast {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        n1.next = n2;
        Node n3 = new Node(2);
        n2.next = n3;
        Node n4 = new Node(3);
        n3.next = n4;
        Node n5 = new Node(4);
        n4.next = n5;
        Node n6 = new Node(5);
        n5.next = n6;
        n6.next = new Node(6);
        System.out.println(nthToLast(n1, 2).data);
    }

    /*
    1. if we know the size we can keep count of it and find the nth
    2. have 2 pointers first one move to 'n' number
       Second one to
     */
    private static Node nthToLast(Node head, int nth) {
        int count = 0;
        Node firstPointer = head;
        while (count != nth) {
            firstPointer = firstPointer.next;
            count++;
        }

        Node current = head;

        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            current = current.next;
        }

        return current;
    }
}
