package dynamic.twodimensional;

import java.util.ArrayList;
import java.util.List;

public class RobotPath {
  public static void main(String[] args) {
    Integer[][] input = {
        {1, -1, 2},
        {3, 4, 5},
        {6, -1, 7}
    };
    List<Integer> path = new ArrayList<>();
    System.out.println(isTherePath(input, input.length - 1, input[0].length - 1, path) + " Path " + path);
    System.out.println(isPath(input));

    input = new Integer[][] {
        {1, -1, 2},
        {3, 4, -1},
        {6, -1, 7}
    };
    path.clear();
    System.out.println(isTherePath(input, input.length - 1, input[0].length - 1, path)+ " Path " + path);
    System.out.println(isPath(input));
  }

  private static boolean isTherePath(Integer[][] grid, int rows, int cols, List<Integer> path) {
    if (rows < 0) {
      return false;
    }

    if (cols < 0) {
      return false;
    }

    if (grid[rows][cols] == -1) {
      return false;
    }

    if (rows == 0 && cols == 0) {
      path.add(grid[rows][cols]);
      return true;
    }

    path.add(grid[rows][cols]);
    boolean pathFromTop = false;
    if (rows > 0 && grid[rows - 1][cols] != -1) {
      pathFromTop = isTherePath(grid, rows - 1, cols, path);
    }

    boolean pathFromLeft = false;
    if (cols > 0 && grid[rows][cols - 1] != -1) {
      pathFromLeft = isTherePath(grid, rows, cols - 1, path);
    }

    boolean result = pathFromTop || pathFromLeft;
    if (!result) {
      path.remove(grid[rows][cols]);
    }

    return result;
  }

  private static boolean isPath(Integer[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] result = new boolean[rows + 1][cols + 1];
    result[1][1] = true;
    for (int row = 1; row <= rows; row++) {
      for (int col = 1; col <= cols; col++) {
        if (row == 1 && col == 1) {
          continue;
        }

        if (grid[row - 1][col - 1] == -1) {
          result[row][col] = false;
        } else {
          result[row][col] = result[row - 1][col] || result[row][col - 1];
        }
      }
    }

    return result[rows][cols];
  }
}
