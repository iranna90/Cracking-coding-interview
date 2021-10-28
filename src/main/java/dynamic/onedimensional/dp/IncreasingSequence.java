package dynamic.onedimensional.dp;

import java.util.concurrent.atomic.AtomicInteger;

public class IncreasingSequence {
  public static void main(String[] args) {
    int[] input = {5, 10, 6, 3, 7, 8, 9};
    AtomicInteger count = new AtomicInteger();
    int result = longestIncreasingSubSequence(input, input.length - 1, count);
    System.out.println(result + " times " + count.get());

    count = new AtomicInteger();
    result = longestIncreasingSubSequenceMemo(input, input.length - 1, count, new int[input.length]);
    System.out.println(result + " times " + count.get());

    result = iterative(input);
    System.out.println(result);
  }

  /*
     [5,2,3,6,8]
     out put 4 -->[2,3,6,8]
     [5,10,6, 3,7,8,9] --- 5,6,7,9 --- 4
     any item at location can be part of the largest sub sequence of the elements which are less then this
     example: item 9 above can be in the sub sequence -- 7, 3, 6, 5 --- and then we find increasing sequence till these items.
     */
  private static int longestIncreasingSubSequence(int[] input, int index, AtomicInteger count) {

    // no item: then can not make a sub sequence
    if (index < 0) {
      return 0;
    }

    // last item: it can form a sequence with one element.
    if (index == 0) {
      return 1;
    }

    count.incrementAndGet();

    int item = input[index];

    int max = Integer.MIN_VALUE;
    for (int i = index - 1; i >= 0; i--) {
      if (input[i] < item) {
        int maxSubSequence = 1 + longestIncreasingSubSequence(input, i, count);
        max = Math.max(max, maxSubSequence);
      } else {
        max = Math.max(max, 1);
      }
    }

    return max;
  }

  private static int longestIncreasingSubSequenceMemo(int[] input, int index, AtomicInteger count, int[] memo) {

    // no item: then can not make a sub sequence
    if (index < 0) {
      return 0;
    }

    // last item: it can form a sequence with one element.
    if (index == 0) {
      return 1;
    }

    if (memo[index] != 0) {
      return memo[index];
    }

    count.incrementAndGet();

    int item = input[index];

    int max = Integer.MIN_VALUE;
    for (int i = index - 1; i >= 0; i--) {
      if (input[i] < item) {
        int maxSubSequence = 1 + longestIncreasingSubSequence(input, i, count);
        max = Math.max(max, maxSubSequence);
      } else {
        max = Math.max(max, 1);
      }
    }

    memo[index] = max;
    return max;
  }

  /*
   formula is: max sequence at i is = 1 + max(dp[i-1].....dp[0]) for all i where item at i < this item
   */
  private static int iterative(int[] input) {
    int[] dp = new int[input.length + 1];
    dp[0] = 0;

    for (int i = 1; i <= input.length; i++) {
      int item = input[i - 1];
      int max = 0;

      for (int j = 0; j < i; j++) {
        if (input[j] < item) {
          max = Math.max(max, dp[j + 1]);
        }
      }

      dp[i] = 1 + max;
    }

    return dp[input.length];
  }
}
