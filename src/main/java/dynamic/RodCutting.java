package dynamic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

public class RodCutting {

    private static AtomicInteger count = new AtomicInteger();
    private static AtomicInteger linear = new AtomicInteger();

    public static void main(String[] args) {
        int[] prices = {3, 5, 10, 9, 10, 17, 17, 20};
        System.out.println(maxProfit(prices, prices.length, new int[prices.length + 1]));
        System.out.println(count.get());
        System.out.println(maxIterative(prices, prices.length));
        System.out.println(linear.get());
    }

    /*

    base case
       - rod of length 0 or < 0 will return 0

    Rod of n
       -
      max(n, prince[1]+rod(n-1), price[2] + rod(n-2),......,price(n-1)+rod(1))

     */
    private static int maxProfit(int[] prices, int rodLength, int[] cache) {

        // if there is no rod left to sell
        if (rodLength <= 0) {
            return 0;
        }

        count.incrementAndGet();

        if (cache[rodLength] != 0) {
            return cache[rodLength];
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= rodLength; i++) {
            int priceOfThisLength = prices[i - 1];
            int remainingRodPrice = maxProfit(prices, rodLength - i, cache);
            int maxPriceByThisLength = priceOfThisLength + remainingRodPrice;
            maxProfit = Math.max(maxProfit, maxPriceByThisLength);

        }

        cache[rodLength] = maxProfit;
        return maxProfit;
    }


    private static int maxIterative(int[] prices, int rodLength) {
        int[] cache = new int[prices.length + 1];
        cache[1] = prices[0];
        for (int i = 2; i <= prices.length; i++) {
            int maxForThis = Integer.MIN_VALUE;

            for (int j = 1; j <= i; j++) {
                int remainingRod = i - j;
                int thisSizeRodPrice = prices[j - 1];
                int remainingRodMaxPrice = cache[remainingRod];
                linear.incrementAndGet();
                maxForThis = Math.max(maxForThis, thisSizeRodPrice + remainingRodMaxPrice);
            }
            cache[i] = maxForThis;
        }
        System.out.println(Arrays.stream(cache).boxed().collect(toList()).toString());
        System.out.println(Arrays.stream(prices).boxed().collect(toList()).toString());
        return cache[prices.length];
    }

}
