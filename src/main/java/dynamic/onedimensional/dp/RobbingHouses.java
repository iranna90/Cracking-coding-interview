package dynamic.onedimensional.dp;

import java.util.concurrent.atomic.AtomicInteger;

public class RobbingHouses {
  public static void main(String[] args) {
    int[] prices = {1, 5, 2, 3, 8};
    AtomicInteger count = new AtomicInteger();
    System.out.println(maxPriceRobbing(prices, prices.length - 1, count) + " and times " + count.get());
    count.set(0);
    System.out.println(maxPriceRobbingMemo(prices, prices.length - 1, new int[prices.length], count) + " and times " + count.get());

    System.out.println(iterative(prices));
  }

  // exponential not 2^n but at max the length of the recursion will be 2^n/2(as alternative house can be n/2 houses)
  private static int maxPriceRobbing(int[] price, int house, AtomicInteger count) {
    if (house < 0) {
      return 0;
    }

    count.incrementAndGet();

    int robCurrentHouse = price[house] + maxPriceRobbing(price, house - 2, count);
    int doNotRobCurrentHouse = maxPriceRobbing(price, house - 1, count);
    return Math.max(robCurrentHouse, doNotRobCurrentHouse);
  }

  private static int maxPriceRobbingMemo(int[] price, int house, int[] memo, AtomicInteger count) {
    if (house < 0) {
      return 0;
    }

    if (memo[house] != 0) {
      return memo[house];
    }

    count.incrementAndGet();
    int robCurrentHouse = price[house] + maxPriceRobbingMemo(price, house - 2, memo, count);
    int doNotRobCurrentHouse = maxPriceRobbingMemo(price, house - 1, memo, count);
    int maxForCurrentHouseIndex = Math.max(robCurrentHouse, doNotRobCurrentHouse);
    memo[house] = maxForCurrentHouseIndex;
    return maxForCurrentHouseIndex;
  }

  private static int iterative(int[] prices) {
    int[] dp = new int[prices.length + 1];
    dp[1] = prices[0];
    for (int house = 2; house <= prices.length; house++) {
      dp[house] = Math.max(prices[house - 1] + dp[house - 2], dp[house - 1]);
    }

    return dp[prices.length];
  }
}
