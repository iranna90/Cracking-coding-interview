package dynamic.onedimensional.dp;

import java.util.concurrent.atomic.AtomicInteger;

public class RodCutting {
  public static void main(String[] args) {
    int[] price = {1, 5, 8, 9, 10};
    AtomicInteger count = new AtomicInteger();
    System.out.println(maxProf(price, price.length, count) + " and the times " + count.get());

    count = new AtomicInteger();
    System.out.println(maxProfMemo(price, price.length, count, new int[price.length + 1]) + " and the times " + count.get());

    System.out.println(iterative(price));
  }

  private static int maxProf(int[] prices, int length, AtomicInteger count) {
    if (length == 0) {
      return 0;
    }

    count.incrementAndGet();

    // now we can cut it in all the possible sub rods and find max
    int max = Integer.MIN_VALUE;
    for (int rodLength = 1; rodLength <= length; rodLength++) {
      int maxProfitWithLength = prices[rodLength - 1] + maxProf(prices, length - rodLength, count);
      max = Math.max(max, maxProfitWithLength);
    }

    return max;
  }

  private static int maxProfMemo(int[] prices, int length, AtomicInteger count, int[] memo) {
    if (length == 0) {
      return 0;
    }

    if (memo[length] != 0) {
      return memo[length];
    }

    count.incrementAndGet();

    // now we can cut it in all the possible sub rods and find max
    int max = Integer.MIN_VALUE;
    for (int rodLength = 1; rodLength <= length; rodLength++) {
      int maxProfitWithLength = prices[rodLength - 1] + maxProfMemo(prices, length - rodLength, count, memo);
      max = Math.max(max, maxProfitWithLength);
    }

    memo[length] = max;

    return max;
  }

  /*
  recursion price of i rod size is = max(p[0]+dp[i-1], p[1]+dp[i-2],......., p[i-2]+dp[1], p[i-1])
  rod of 1 dp[1] = p[0]
  rod of 2 = max(p[0]+dp[1], p[1]+dp[0])
  rod of 3 = max(p[0]+dp[2], p[1]+dp[1], p[2]+dp[0])
   */
  private static int iterative(int[] prices) {
    int[] dp = new int[prices.length + 1];
    dp[1] = prices[0];
    for (int rodLength = 2; rodLength <= prices.length; rodLength++) {
      int max = Integer.MIN_VALUE;
      for (int subLength = 1; subLength <= rodLength; subLength++) {
        max = Math.max(max, prices[subLength - 1] + dp[rodLength - subLength]);
      }
      dp[rodLength] = max;
    }

    return dp[prices.length];
  }
}
