package dynamic.previous;

public class AdjucentHouseRobbery {
  public static void main(String[] args) {
    int[] houses = {10, 8, 9, 20};
    System.out.println(maxRobbery(houses, houses.length));
    System.out.println(linear(houses, houses.length));
  }

  private static int maxRobbery(int[] prices, int nextHouseNumberToBeRobbed) {
    if (nextHouseNumberToBeRobbed <= 0) {
      return 0;
    }

    int maxByRobbingThisHouse = prices[nextHouseNumberToBeRobbed - 1] + maxRobbery(prices, nextHouseNumberToBeRobbed - 2);
    int maxWithoutRobbingCurrentHouse = maxRobbery(prices, nextHouseNumberToBeRobbed - 1);
    return Math.max(maxByRobbingThisHouse, maxWithoutRobbingCurrentHouse);
  }

  /*
  Recursive formula is
  max(i) = MAX(p[i]+max(i-2), max(i-1))
  */
  private static int linear(int[] prices, int houses) {
    int[] maxProfit = new int[houses + 1];
    maxProfit[1] = prices[0];
    for (int i = 2; i <= houses; i++) {
      int includingThisHouse = prices[i - 1] + maxProfit[i - 2];
      int excludingThisHouse = maxProfit[i - 1];
      maxProfit[i] = Math.max(includingThisHouse, excludingThisHouse);
    }

    return maxProfit[houses];
  }
}
