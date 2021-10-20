package dynamic;

/*

Find the number of islands | Set 1 (Using DFS)
Difficulty Level : Medium
Last Updated : 10 Sep, 2021

Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
Example:


Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}}
Output : 5
This is a variation of the standard problem: “Counting the number of connected components in an undirected graph”.

 */
public class Island {
  public static void main(String[] args) {
   /* int[][] mat = {
        {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    }; */

    int[][] mat = {
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 0},
        {0, 1, 1, 1, 1},
        {0, 0, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {1, 0, 0, 1, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 1, 0, 0}
    };

    System.out.println(findIslands(mat, mat.length, mat[0].length));
  }

  /*
  As any element at location (i, j) can not be a new island if it's previous items at location (i, j-1) (i-1, j-1) (i-1, j) (i-1, j+1) is already a island.
   */
  private static int findIslands(final int[][] mat, int rows, int cols) {
    int totalIslands = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int location = mat[row][col];
        if (location == 1 && notPartOfPreviousIslands(mat, row, col)) {
          totalIslands += 1;
        }
      }
    }

    return totalIslands;
  }

  // (row, col-1) (row-1, col-1) (row-1, col) (row-1, col+1) (row, col+1)
  private static boolean notPartOfPreviousIslands(final int[][] mat, final int row, final int col) {
    // left element
    if (col - 1 >= 0 && mat[row][col - 1] == 1) {
      return false;
    }

    // left diagonal
    if (row - 1 >= 0 && col - 1 >= 0 && mat[row - 1][col - 1] == 1) {
      return false;
    }

    // above item
    if (row - 1 >= 0 && mat[row - 1][col] == 1) {
      return false;
    }

    // right diagonal
    if (row - 1 >= 0 && col + 1 < mat[0].length && mat[row - 1][col + 1] == 1) {
      return false;
    }

    return true;
  }


}
