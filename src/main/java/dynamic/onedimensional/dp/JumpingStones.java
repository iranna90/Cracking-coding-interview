package dynamic.onedimensional.dp;

import java.util.concurrent.atomic.AtomicInteger;

public class JumpingStones {
  public static void main(String[] args) {
    int[] input = {0, 20, 30, 20, 40, 10, 20};
    int x = 4;       // result = 50
    AtomicInteger count = new AtomicInteger();
    System.out.println(jump(input, input.length - 1, x, count) + " times " + count.get());

    count = new AtomicInteger();
    System.out.println(jumpMemo(input, input.length - 1, x, count, new int[input.length]) + " times " + count.get());

    System.out.println(iterative(input, x));
  }

  private static int jump(int[] cost, int place, int x, AtomicInteger count) {
    if (place <= 0) {
      return 0;
    }

    count.incrementAndGet();

    int min = Integer.MAX_VALUE;
    for (int step = 1; step <= x; step++) {
      int currentStep = cost[place] + jump(cost, place - step, x, count);
      min = Math.min(min, currentStep);
    }

    return min;
  }

  private static int jumpMemo(int[] cost, int place, int x, AtomicInteger count, int[] memo) {
    if (place <= 0) {
      return 0;
    }

    if (memo[place] != 0) {
      return memo[place];
    }

    count.incrementAndGet();

    int min = Integer.MAX_VALUE;
    for (int step = 1; step <= x; step++) {
      int currentStep = cost[place] + jumpMemo(cost, place - step, x, count, memo);
      min = Math.min(min, currentStep);
    }
    memo[place] = min;
    return min;
  }

  private static int iterative(int[] cost, int x) {
    int[] dp = new int[cost.length];

    for (int i = 1; i < cost.length; i++) {
      int stepCost = cost[i];
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= x; j++) {
        if (i - j >= 0) {
          min = Math.min(min, dp[i - j]);
        }
      }

      dp[i] = min + stepCost;
    }

    return dp[cost.length - 1];
  }
}
