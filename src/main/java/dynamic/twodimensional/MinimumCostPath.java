package dynamic.twodimensional;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostPath {

    public static void main(String[] args) {
        int[][] input = {
                {0, 47, 8, 18, 1},
                {43, 25, 39, 36, 13},
                {22, 8, 13, 38, 46},
                {41, 41, 40, 25, 44},
                {29, 43, 22, 50, 10}
        };

 /*   int[][] input = {
        {0,1,3},
        {4,6,1},
        {8,9,2}
    };*/
        List<Integer> path = new ArrayList<>();
        System.out.println(mimCost(input, input.length - 1, input[0].length - 1));
        System.out.println(iterative(input));
    }


    private static int mimCost(int[][] input, int row, int col) {
        if (row == 0 && col == 0) {
            return input[row][col];
        }

        int locationValue = input[row][col];

        int min = Integer.MAX_VALUE;
        if (row > 0) {
            min = Math.min(min, mimCost(input, row - 1, col));
        }

        if (col > 0) {
            min = Math.min(min, mimCost(input, row, col - 1));
        }

        return locationValue + min;
    }

    /*
    formula is
    input[0][0]
    i,j location = current + min(dp[i-1][j], dp[i][j-1])

    so dp[2][3] = cost[2][3]+ min( dp[1][3], dp[2][2]
     */
    private static int iterative(int[][] input) {
        int[][] dp = new int[input.length + 1][input[0].length + 1];

        // fill all the rows with column 0
        for (int row = 0; row <= input.length; row++) {
            dp[row][0] = Integer.MAX_VALUE;
        }

        // fill all the columns of row 0
        for (int col = 0; col <= input[0].length; col++) {
            dp[0][col] = Integer.MAX_VALUE;
        }

        dp[1][1] = input[0][0];

        for (int row = 1; row <= input.length; row++) {
            for (int col = 1; col <= input[0].length; col++) {
                if (row==1 && col == 1) {
                    continue;
                }

                dp[row][col] = input[row-1][col-1] + Math.min(dp[row-1][col], dp[row][col-1]);
            }
        }

        return dp[input.length][input[0].length];
    }

}
