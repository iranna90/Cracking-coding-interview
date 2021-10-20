package dynamic;

public class PaintingHouses {
    public static void main(String[] args) {
        int[][] costs = {
                //R  B   G
                {17, 2, 17}, // 1
                {16, 16, 5},  // 2
                {14, 3, 9}  // 3
        };

        int redStart = costs[2][Color.RED.position] + minimumCost(costs, 2, Color.RED);
        int blueStart = costs[2][Color.BLUE.position] + minimumCost(costs, 2, Color.BLUE);
        int greenStart = costs[2][Color.GREEN.position] + minimumCost(costs, 2, Color.GREEN);

        System.out.println(Math.min(Math.min(redStart, blueStart), greenStart));
        System.out.println(bestPainting(costs, costs.length));
    }

    private static int minimumCost(int[][] costs, int remainingHouses, Color previousColor) {
        if (remainingHouses == 0) {
            return 0;
        }

        if (previousColor == Color.RED) {
            int blueColor = costs[remainingHouses - 1][Color.BLUE.position] + minimumCost(costs, remainingHouses - 1, Color.BLUE);
            int greenColor = costs[remainingHouses - 1][Color.GREEN.position] + minimumCost(costs, remainingHouses - 1, Color.GREEN);
            return Math.min(blueColor, greenColor);
        }

        if (previousColor == Color.BLUE) {
            int greenColor = costs[remainingHouses - 1][Color.GREEN.position] + minimumCost(costs, remainingHouses - 1, Color.GREEN);
            int redColor = costs[remainingHouses - 1][Color.RED.position] + minimumCost(costs, remainingHouses - 1, Color.RED);
            return Math.min(redColor, greenColor);
        }


        int blueColor = costs[remainingHouses - 1][Color.BLUE.position] + minimumCost(costs, remainingHouses - 1, Color.BLUE);
        int redColor = costs[remainingHouses - 1][Color.RED.position] + minimumCost(costs, remainingHouses - 1, Color.RED);
        return Math.min(blueColor, redColor);

    }

    /*

    i and j --- i is house number and j is color


    dp[i][RED] = p[i][RED] + min(d[i-1][BLUE], dp[i-1][GREEN])
    dp[i][BLUE] = p[i][BLUE] + min(d[i-1][RED], dp[i-1][GREEN])
    dp[i][GREEN] = p[i][GREEN] + min(d[i-1][BLUE], dp[i-1][RED])

    min(dp[i][RED], dp[i][BLUE], dp[i][GREEN])

     */

    private static int bestPainting(int[][] costs, int n) {
        int[][] cache = new int[n + 1][3];

        for (int i = 1; i < n + 1; i++) {
            cache[i][Color.RED.position] = costs[i - 1][Color.RED.position] + Math.min(cache[i - 1][Color.BLUE.position], cache[i - 1][Color.GREEN.position]);
            cache[i][Color.BLUE.position] = costs[i - 1][Color.BLUE.position] + Math.min(cache[i - 1][Color.RED.position], cache[i - 1][Color.GREEN.position]);
            cache[i][Color.GREEN.position] = costs[i - 1][Color.GREEN.position] + Math.min(cache[i - 1][Color.BLUE.position], cache[i - 1][Color.RED.position]);
        }

        return Math.min(Math.min(cache[n][Color.RED.position], cache[n][Color.BLUE.position]), cache[n][Color.GREEN.position]);
    }

    private enum Color {
        RED(0),
        BLUE(1),
        GREEN(2);

        private final int position;

        Color(int position) {
            this.position = position;
        }
    }
}
