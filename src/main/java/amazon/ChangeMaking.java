package amazon;

/*
Suppose we have coin denominations of [1, 2, 5] and the total amount is 7.
We can make changes in the following 6 ways:
 */
/*

 */
public class ChangeMaking {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 7};
        System.out.println(numberOfWays(7, coins, 0));
        System.out.println(minimumCoins(7, coins, 0, 0));
    }


    private static int numberOfWays(int remaining, int[] coins, int index) {
        if (remaining < 0) {
            return 0;
        }

        if (remaining == 0) {
            return 1;
        }

        int totalWays = 0;
        for (int i = index; i < coins.length; i++) {
            int coin = coins[i];
            totalWays += numberOfWays(remaining - coin, coins, i);
        }

        return totalWays;
    }

    private static int minimumCoins(int remaining, int[] coins, int index, int countCoins) {
        if (remaining < 0) {
            return Integer.MAX_VALUE;
        }

        if (remaining == 0) {
            return countCoins;
        }

        int minimumCoins = Integer.MAX_VALUE;
        for (int i = index; i < coins.length; i++) {
            int coin = coins[i];
            minimumCoins = Math.min(minimumCoins, minimumCoins(remaining - coin, coins, i, countCoins + 1));
        }

        return minimumCoins;
    }
}
