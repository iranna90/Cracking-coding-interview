package amazon;

public class MissingNumber {
  public static void main(String[] args) {
    int[] input = {1, 2, 3, 8, 7, 6, 5};
    System.out.println(missingNumber(input));
    input = new int[] {1, 2, 3, 8, 7, 6, 5, 4};
    System.out.println(missingNumber(input));
    input = new int[] {1, 2, 3, 8, 7, 6, 5, 5, 5, 4};
    System.out.println(missingNumber(input));
  }

  // we can sort and check the next number with previous and it will take O(n^2)

  // we can use count the number from 1 to size, once we process the numbers and something missing we can print that as a missing element.
  // time O(n)
  // space O(n)
  private static int missingNumber(int[] input) {

    if (input == null || input.length <= 1) {
      return -1;
    }

    int[] count = new int[input.length + 2]; // starting from 1
    int numberOfDistinctElements = 0;
    for (int item : input) {
      if (count[item] == 0) {
        numberOfDistinctElements++;
      }
      count[item] = count[item] + 1;
    }

    for (int i = 1; i <= numberOfDistinctElements; i++) {
      if (count[i] == 0) {
        return i;
      }
    }

    return -1;
  }


  // we can use total sum and actual sum from the elements
  private static int missing(int[] input) {
    int sum = 0;
    for (int item : input) {
      sum += item;
    }

    int expectedSum = 0;
    for (int i = 1; i <= input.length; i++) {
      expectedSum += i;
    }

    return expectedSum - sum;
  }
}
