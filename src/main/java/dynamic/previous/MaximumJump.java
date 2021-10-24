package dynamic.previous;

public class MaximumJump {
  public static void main(String[] args) {
    int[] input = {20, 30, 40, 25, 15, 20, 28};
    System.out.println(minCost(input, 3, input.length - 1));
    System.out.println(linear(input, 3));
  }

  /*
  From any given stone i can jump in x different ways 1 to X -- and pay corresponding
  min(pay(1)jump(i-1), ...... pay(x)jump(i-x))

  base = i == 0 => 0


   */
  private static int minCost(int[] prices, int x, int index) {
    if (index == 0) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    // min(5) = cost[5] + MIN(min(4), min(3), min(2))
    for (int j = 1; j <= Math.min(x, index); j++) {
      min = Math.min(min, minCost(prices, x, index - j) + prices[index]);
    }

    return min;
  }


  private static int linear(int[] prices, int x) {
    int[] dp = new int[prices.length];
    for (int i = 1; i < prices.length; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= Math.min(x, i); j++) {
        min = Math.min(min, prices[i] + dp[i - j]);
      }
      dp[i] = min;
    }
    return dp[prices.length - 1];
  }
}
