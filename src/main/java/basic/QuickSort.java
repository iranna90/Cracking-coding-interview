package basic;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] a = {5, 4, 6, 2, 1};
    quickSort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }

  /*
  Quick sort pick the pivotal element and them make sure all the elements at the right of the pivot are higher then pivot
  and all the elements at the left of the pivot are lower
  [7,8,3,2,9]
  pivot is 3
  i=0 -- find element which is greater then pivot
  j=4 == find element which is smaller then then pivot
  [2,8,3,7,9]
  i=1 and j=3 -- repeat until i >= j and return that as separator
   */


  /*
  {5, 4, 6, 2, 1};
  pivot = input[4/2] = 6



   */
  public static void quickSort(int[] input, int start, int end) {
    if (start >= end) {
      return;
    }

    int pivot = input[(start + end) / 2]; // consider middle element as pivot
    int partitionIndex = alignElements(input, start, end, pivot);
    quickSort(input, start, partitionIndex - 1);
    quickSort(input, partitionIndex, end);
  }

  /*
  [7,8,3,2,9]
  pivot 3
  startIndex = 0 and endIndex = 4
  1. startIndex = 0 and endIndex=3 ---> swap the elements [2,8,3,7,9] -- startIndex = 1, endIndex=2
  2. startIndex = 1, endIndex=2 ---> swap [2,3,8,7,9] --- startIndex = 2 endIndex = 1
   */

  /*
   {5, 4, 6, 2, 1};
  pivot = input[4/2] = 6
  start = 0;
  end = 4;
  ------------------------
  start = 2
  end = 4
  swap === {5, 4, 1, 2, 6}; start = 3 end = 3
  start = 4
  end = 3
   */
  private static int alignElements(final int[] input, final int start, final int end, final int pivot) {
    int startIndex = start;
    int endIndex = end;
    System.out.println("start "+start+" end "+end+" pivot "+pivot);
    while (startIndex <= endIndex) {
      // find startIndex position
      while (input[startIndex] < pivot) {
        startIndex++;
      }

      // find end index
      while (input[endIndex] > pivot) {
        endIndex--;
      }

      // both the startIndex points to element greater than pivot and endIndex points to element less then pivot
      //swap the result
      if(startIndex <= endIndex) {
        int temp = input[startIndex];
        input[startIndex] = input[endIndex];
        input[endIndex] = temp;
        startIndex++;
        endIndex--;
      }
      System.out.println("si "+startIndex+" end index "+endIndex);
    }

    return startIndex;
  }
}
