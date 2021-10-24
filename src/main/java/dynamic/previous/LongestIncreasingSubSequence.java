package dynamic.previous;

public class LongestIncreasingSubSequence {
  public static void main(String[] args) {
    int input[] = {1, 2, 3, 4, 5, 6, 2, 3, 6, 8};
    System.out.println(largest(input, input.length - 1));
  }

  private static int largest(int[] input, int index) {
    if (index == 0) {
      return 1;
    }

    int max = 0;
    for (int j = 0; j < index; j++) {
      int temp = largest(input, j);
      if (input[index] > input[j]) {
        temp += 1;
      }
      max = Math.max(max, temp);
    }

    return max;
  }
}
