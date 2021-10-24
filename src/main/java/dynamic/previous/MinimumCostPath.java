package dynamic.previous;

public class MinimumCostPath {
  public static void main(String[] args) {

    int cost[][] = {
        {1, 2, 3},
        {4, 8, 2},
        {1, 5, 3}
    };

    System.out.println(mcp(cost, cost.length - 1, cost[0].length - 1));
    System.out.println(linear(cost, cost.length, cost[0].length));
  }

  /*
  Can walk only right and down
  means from the bottom person can walk only up and left, no right.

  base is row and col =0 will return 0
  if row =0 => dp[i][j] = cost[i][j-1] + dp[i][j-1]
  if col =0 => dp[i][j] = cost[i-1][j] + dp[i-1][j]
  formula = dp[i][j] = min(cost[i][j-1]+d[i][j-1], cost[i-1][j]+d[i-1][j]
   */
  private static int mcp(int[][] cost, int row, int col) {
    if (row == 0 && col == 0) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    if (row > 0) {
      min = Math.min(min, cost[row - 1][col] + mcp(cost, row - 1, col));
    }

    if (col > 0) {
      min = Math.min(min, cost[row][col - 1] + mcp(cost, row, col - 1));
    }
    return min;
  }

  /*
    base is rows and cols =0 will return 0
  if rows =0 => dp[i][j] = cost[i][j-1] + dp[i][j-1]
  if cols =0 => dp[i][j] = cost[i-1][j] + dp[i-1][j]
  formula = dp[i][j] = min(cost[i][j-1]+d[i][j-1], cost[i-1][j]+d[i-1][j]
   */
  private static int linear(int[][] cost, int rows, int cols) {
    // in the cache we consider 0,0 is 1,1
    int[][] dp = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {

        if (i == 0 && j == 0) {
          continue;
        }

        int min = Integer.MAX_VALUE;
        if (i > 0) {
          min = Math.min(min, cost[i - 1][j] + mcp(cost, i - 1, j));
        }

        if (j > 0) {
          min = Math.min(min, cost[i][j - 1] + mcp(cost, i, j - 1));
        }

        dp[i][j] = min;
      }
    }
    return dp[rows - 1][cols - 1];
  }
}
