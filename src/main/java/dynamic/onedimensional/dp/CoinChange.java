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
 At any point we have 2 choices.
 either include this item or do not include we will calculate the sum of both choice.
 result[i][j] = result[i-coin][j] + result[i][j-1]
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

  /*

   */
  private static int iterative(int[] coins, int totalAmount) {
    int[] result = new int[totalAmount + 1];
    result[0] = 1;
    for (final int coin : coins) {
      for (int j = coin; j <= totalAmount; j++) {
        result[j] += result[j - coin];
      }
    }

    return result[totalAmount];
  }
}
