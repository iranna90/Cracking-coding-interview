package dynamic.onedimensional.dp;

import java.util.concurrent.atomic.AtomicInteger;

/*
N = 10 and S = {2, 5, 3, 6}
result 5 ways
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}

Minimum coins: {5,5}
Maximum coins: {2,2,2,2,2}
 */
public class CoinChange {
  public static void main(String[] args) {
    int[] input = {2, 5, 3, 6};
    int amount = 10;
    AtomicInteger count = new AtomicInteger();
    System.out.println(makeChange(input, input.length - 1, amount, count) + " times " + count.get());
    System.out.println(iterative(input, amount));
  }

  /*
  Can choose any item from the list and have to find best for the remaining.
  so the coin change of i amount is = makeChange(i-j) for all j in coin list
  base j==0 return 1
  j < 0 return 0
   */
  private static int makeChange(int[] coins, int index, int amount, AtomicInteger count) {

    if (amount == 0) {
      return 1;
    }

    if (amount < 0 || index < 0) {
      return 0;
    }

    count.incrementAndGet();
    int coin = coins[index];

    int waysWithThisCoin = makeChange(coins, index, amount - coin, count);
    int wayWithoutThisCoin = makeChange(coins, index - 1, amount, count);

    return waysWithThisCoin + wayWithoutThisCoin;
  }

  private static int iterative(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    /*for (int subAmount = 1; subAmount <= amount; subAmount++) {

      int ways = 0;
      for (final int coin : coins) {
        if (subAmount - coin >= 0) {
          ways = ways + dp[subAmount - coin];
        }
      }

      dp[subAmount] = ways;
    }*/


    for (final int coin : coins) {
      for (int j = 1; j <= amount; j++) {
        if (j - coin >= 0) {
          dp[j] += dp[j - coin];
        }
      }
    }
    return dp[amount];
  }
}
