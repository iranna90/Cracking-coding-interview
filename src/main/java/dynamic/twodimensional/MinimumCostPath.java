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
    System.out.println(path);
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

}
