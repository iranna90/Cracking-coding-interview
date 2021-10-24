package dynamic.previous;

public class Heap {

  private final int[] heap;
  private int items;

  public Heap(final int size) {
    this.heap = new int[size];
    this.items = 0;
  }

  public static void main(String[] args) {

  }

  private int peek() {
    return heap[0];
  }

  private int removeItem() {
    int item = heap[0];
    heapifyDown(0);
    items -= 1;
    return item;
  }

  private void addItem(int item) {
    if (items == heap.length) {
      throw new RuntimeException("The heap is full");
    }

    heap[items] = item;
    heapifyUp(items);
    items += 1;
  }

  private int leftChild(int parentLocation) {
    return parentLocation * 2 + 1;
  }

  private int rightChild(int parentLocation) {
    return parentLocation * 2 + 2;
  }

  private int parentLocation(int childLocation) {
    double result = (double) childLocation / 2;
    return (int) Math.round(result) - 1;
  }

  private void heapifyUp(int location) {
    // it is the parent
    if (location == 0) {
      return;
    }

    // check whether need to be swapped
    int parentLocation = parentLocation(location);
    if (heap[parentLocation] < heap[location]) {
      return;
    }

    swap(location, parentLocation);
    heapifyUp(parentLocation);
  }

  private void swap(final int location, final int parentLocation) {
    int temp = heap[location];
    heap[location] = heap[parentLocation];
    heap[parentLocation] = temp;
  }

  private void heapifyDown(int location) {
    int leftChild = leftChild(location);
    int rightChild = rightChild(location);

    if (leftChild >= items) {
      return;
    }

    if (rightChild >= items) {
      // swap with left child;
      swap(location, leftChild);
      return;
    }

    // both elements are there.
    if (heap[leftChild] < heap[rightChild]) {
      swap(location, leftChild);
      heapifyDown(leftChild);
    } else {
      swap(location, rightChild);
      heapifyDown(rightChild);
    }
  }

}
