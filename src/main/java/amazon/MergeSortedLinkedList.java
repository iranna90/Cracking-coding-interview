package amazon;

import tree.Node;

import static utils.Utils.printLinkedList;

public class MergeSortedLinkedList {
  public static void main(String[] args) {
    Node firstList = new Node(1);
    Node three = new Node(3);
    firstList.next = three;
    three.next = new Node(6);
    printLinkedList(firstList);
    System.out.println();

    Node secondList = new Node(2);
    Node four = new Node(4);
    secondList.next = four;
    Node eight = new Node(8);
    four.next = eight;
    eight.next = new Node(9);
    printLinkedList(secondList);
    System.out.println();

    Node node = mergeTree(firstList, secondList);
    printLinkedList(node);
  }

  private static Node mergeTree(Node firstListNode, Node secondListNode) {
    Node resultHead = null;
    Node resultCurrent = null;
    while (firstListNode != null && secondListNode != null) {
      Node newNode;
      if (firstListNode.data < secondListNode.data) {
        newNode = new Node(firstListNode.data);
        firstListNode = firstListNode.next;
      } else {
        newNode = new Node(secondListNode.data);
        secondListNode = secondListNode.next;
      }

      if (resultCurrent != null) {
        resultCurrent.next = newNode;
      }

      resultCurrent = newNode;

      if (resultHead == null) {
        resultHead = resultCurrent;
      }
    }

    copyRemaining(firstListNode, resultCurrent);

    copyRemaining(secondListNode, resultCurrent);

    return resultHead;
  }

  private static void copyRemaining(Node source, Node destination) {
    while (source != null) {
      Node newNode = new Node(source.data);
      source = source.next;
      if (destination != null) {
        destination.next = newNode;
      }
      destination = newNode;
    }
  }
}
