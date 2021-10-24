package dynamic.previous;

/**
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example,
 * if the length of the rod is 8 and the values of different pieces are given as the following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 */
public class CuttingRod {
  public static void main(String[] args) {
    int[] input = {1, 5, 8, 9, 10, 17, 17, 20};
    System.out.println(maxProfit(input, input.length));
    System.out.println(linear(input, input.length));
  }

  private static int maxProfit(int[] prices, int size) {
    if (size <= 0) {
      return 0;
    }

    int maxProfit = Integer.MIN_VALUE;

    for (int i = 1; i <= size; i++) {
      int profitWithThisLength = prices[i - 1] + maxProfit(prices, size - i);
      maxProfit = Math.max(maxProfit, profitWithThisLength);
    }

    return maxProfit;
  }

  /*
  Algorithm is
  base case when rod is 1 length
  n = min(p[i]+max(n-i) -- where I changes from n to 1
   */
  private static int linear(int[] prices, int size) {
    int[] cache = new int[size + 1];
    cache[1] = prices[0];
    for (int i = 2; i <= size; i++) {
      int maximumProfit = Integer.MIN_VALUE;
      for (int j = 1; j <= i; j++) {
        maximumProfit = Math.max(maximumProfit, prices[j - 1] + cache[i - j]);
      }
      cache[i] = maximumProfit;
    }

    return cache[size];
  }
}
