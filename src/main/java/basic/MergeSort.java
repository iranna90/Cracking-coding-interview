package basic;

import java.util.Arrays;

/*
Time complexity
if array is side n then we divide it into equal parts until we reach single elements, which means dividing is log(n) but once it is
divided we start merging in each phase, so in each level of the division we touch all the elements which is n
So over all time complexity is (n * log(n))
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] a = {5, 4, 6, 2, 1};
    mergeSort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }

  /*
  Merge sort you divide the array and then merge the divided array in sorted format
  you divide the array until it reaches single elements (start == end)
   */
  public static void mergeSort(int[] input, int start, int end) {
    if (start == end) {
      return;
    }

    int medium = (start + end) / 2;

    mergeSort(input, start, medium);
    mergeSort(input, medium + 1, end);
    // merge the result
    merge(input, start, medium, end);
  }

  private static void merge(final int[] input, final int start, final int medium, final int end) {
    int[] temp = new int[end - start + 1];
    int firstHalfIndex = start;
    int secondHalfIndex = medium + 1;
    int tempIndex = 0;
    while (firstHalfIndex <= medium && secondHalfIndex <= end) {
      if (input[firstHalfIndex] > input[secondHalfIndex]) {
        temp[tempIndex] = input[secondHalfIndex];
        secondHalfIndex++;
      } else {
        temp[tempIndex] = input[firstHalfIndex];
        firstHalfIndex++;
      }
      tempIndex++;
    }

    // either elements left in first half or second half
    if (firstHalfIndex <= medium) {
      System.arraycopy(input, firstHalfIndex, temp, tempIndex, medium - firstHalfIndex + 1);
    }

    if (secondHalfIndex <= end) {
      System.arraycopy(input, secondHalfIndex, temp, tempIndex, end - secondHalfIndex + 1);
    }

    // temp will have all sorted data now replace this data in input array
    System.arraycopy(temp, 0, input, start, temp.length);
  }
}
