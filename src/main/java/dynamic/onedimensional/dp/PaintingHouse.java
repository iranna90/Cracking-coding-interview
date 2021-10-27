package dynamic.onedimensional.dp;

import java.util.concurrent.atomic.AtomicInteger;

public class PaintingHouse {
  public static void main(String[] args) {
    int[][] cost = {
        {17, 2, 17},
        {16, 16, 5},
        {14, 3, 9}
    };

    AtomicInteger count = new AtomicInteger();
    int startWithRed = cost[cost.length - 1][Color.RED.index] + minCost(cost, cost.length - 2, Color.RED, count);
    int startWithBlue = cost[cost.length - 1][Color.BLUE.index] + minCost(cost, cost.length - 2, Color.BLUE, count);
    int startWithGreen = cost[cost.length - 1][Color.GREEN.index] + minCost(cost, cost.length - 2, Color.GREEN, count);
    int result = Math.min(Math.min(startWithRed, startWithBlue), startWithGreen);
    System.out.println(result + " and the count of execution is " + count.get());


    count = new AtomicInteger();
    int[][] memo = new int[cost.length + 1][cost[0].length + 1];
    startWithRed = cost[cost.length - 1][Color.RED.index] + minCostMemo(cost, cost.length - 2, Color.RED, memo, count);
    startWithBlue = cost[cost.length - 1][Color.BLUE.index] + minCostMemo(cost, cost.length - 2, Color.BLUE, memo, count);
    startWithGreen = cost[cost.length - 1][Color.GREEN.index] + minCostMemo(cost, cost.length - 2, Color.GREEN, memo, count);
    result = Math.min(Math.min(startWithRed, startWithBlue), startWithGreen);
    System.out.println(result + " and the count of execution is " + count.get());

    result = iterative(cost);
    System.out.println(result + " and result is linear");
  }

  private enum Color {
    RED(0),
    GREEN(1),
    BLUE(2);

    private final int index;

    Color(final int index) {
      this.index = index;
    }
  }

  private static int minCost(int[][] cost, int house, Color color, AtomicInteger count) {
    if (house < 0) {
      return 0;
    }

    count.incrementAndGet();
    // we painted previous house with color RED
    if (color == Color.RED) {
      int blueCost = cost[house][Color.BLUE.index] + minCost(cost, house - 1, Color.BLUE, count);
      int greenCost = cost[house][Color.GREEN.index] + minCost(cost, house - 1, Color.GREEN, count);
      return Math.min(blueCost, greenCost);
    }

    if (color == Color.BLUE) {
      int greenCost = cost[house][Color.GREEN.index] + minCost(cost, house - 1, Color.GREEN, count);
      int redCost = cost[house][Color.RED.index] + minCost(cost, house - 1, Color.RED, count);
      return Math.min(greenCost, redCost);
    }

    // previous color was green
    int redCost = cost[house][Color.RED.index] + minCost(cost, house - 1, Color.RED, count);
    int blueCost = cost[house][Color.BLUE.index] + minCost(cost, house - 1, Color.BLUE, count);
    return Math.min(redCost, blueCost);
  }

  private static int minCostMemo(int[][] cost, int house, Color color, int[][] memo, AtomicInteger count) {
    if (house < 0) {
      return 0;
    }

    if (memo[house][color.index] != 0) {
      return memo[house][color.index];
    }

    count.incrementAndGet();
    // we painted previous house with color RED
    if (color == Color.RED) {
      int blueCost = cost[house][Color.BLUE.index] + minCostMemo(cost, house - 1, Color.BLUE, memo, count);
      int greenCost = cost[house][Color.GREEN.index] + minCostMemo(cost, house - 1, Color.GREEN, memo, count);
      int subCost = Math.min(blueCost, greenCost);
      memo[house][color.index] = subCost;
      return subCost;
    }

    if (color == Color.BLUE) {
      int greenCost = cost[house][Color.GREEN.index] + minCostMemo(cost, house - 1, Color.GREEN, memo, count);
      int redCost = cost[house][Color.RED.index] + minCostMemo(cost, house - 1, Color.RED, memo, count);
      int subCost = Math.min(greenCost, redCost);
      memo[house][color.index] = subCost;
      return subCost;
    }

    // previous color was green
    int redCost = cost[house][Color.RED.index] + minCostMemo(cost, house - 1, Color.RED, memo, count);
    int blueCost = cost[house][Color.BLUE.index] + minCostMemo(cost, house - 1, Color.BLUE, memo, count);
    int subCost = Math.min(redCost, blueCost);
    memo[house][color.index] = subCost;
    return subCost;
  }

  private static int iterative(int[][] cost) {
    // 0 row and 0 column will be 0 as there is now house and no paint to paint the house.
    int[][] dp = new int[cost.length + 1][cost[0].length + 1];
    for (int houseNumber = 1; houseNumber <= cost.length; houseNumber++) {
      dp[houseNumber][Color.RED.index + 1] = cost[houseNumber - 1][Color.RED.index] + Math.min(dp[houseNumber - 1][Color.BLUE.index + 1], dp[houseNumber - 1][Color.GREEN.index + 1]);
      dp[houseNumber][Color.GREEN.index + 1] = cost[houseNumber - 1][Color.GREEN.index] + Math.min(dp[houseNumber - 1][Color.BLUE.index + 1], dp[houseNumber - 1][Color.RED.index + 1]);
      dp[houseNumber][Color.BLUE.index + 1] = cost[houseNumber - 1][Color.BLUE.index] + Math.min(dp[houseNumber - 1][Color.RED.index + 1], dp[houseNumber - 1][Color.GREEN.index + 1]);
    }

    // return the smaller value from the last row
    int row = cost.length;
    int min = Integer.MAX_VALUE;
    for (int col = 1; col < 4; col++) {
      min = Math.min(min, dp[row][col]);
    }

    return min;
  }
}
