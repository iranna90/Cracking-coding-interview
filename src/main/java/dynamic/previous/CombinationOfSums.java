package dynamic.previous;

public class CombinationOfSums {
  public static void main(String[] args) {
    int[] input = {1, 1, 2, 5, 6, 7, 10};
    comb(input, 8, 0, 0, "");
  }

  private static void comb(final int[] input, final int targetSum, int nextIndex, int sum, String result) {

    if (sum == targetSum) {
      System.out.println(result);
      return;
    }

    if (sum > targetSum) {
      return;
    }

    if (nextIndex >= input.length) {
      return;
    }

    // with next item
    int nextItem = input[nextIndex];
    comb(input, targetSum, nextIndex + 1, sum + nextItem, result + nextItem);
    // without item
    comb(input, targetSum, nextIndex + 1, sum, result);
  }

}
