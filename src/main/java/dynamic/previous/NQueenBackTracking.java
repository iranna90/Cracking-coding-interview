package dynamic.previous;

public class NQueenBackTracking {
  public static void main(String[] args) {
    int n = 25;
    int[][] board = new int[n][n];
    System.out.println(nQueen(n, board, 0));
  }

  private static boolean nQueen(final int n, final int[][] board, int nextRow) {

    if (nextRow >= n) {
      printSolution(board, n);
      return true;
    }

    for (int col = 0; col < n; col++) {
      if (isSafe(board, nextRow, col)) {
        board[nextRow][col] = 1;
        boolean solved = nQueen(n, board, nextRow + 1);
        if (solved) {
          return true;
        }
        board[nextRow][col] = 0;
      }
    }

    return false;
  }

  private static void printSolution(int[][] board, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(" " + board[i][j]
            + " ");
      }
      System.out.println();
    }
  }

  private static boolean isSafe(int board[][], int row, int col) {
    // check same column
    for (int eachPreviousRows = row - 1; eachPreviousRows >= 0; eachPreviousRows--) {
      if (board[eachPreviousRows][col] == 1) {
        return false;
      }
    }

    // check left diagonal
    for (int diagonalRow = row - 1, diagonalColumn = col - 1;
         diagonalRow >= 0 && diagonalColumn >= 0;
         diagonalColumn--, diagonalRow--) {
      if (board[diagonalRow][diagonalColumn] == 1) {
        return false;
      }
    }

    // check right diagonal
    for (int diagonalRow = row - 1, diagonalColumn = col + 1; diagonalRow >= 0 && diagonalColumn < board.length; diagonalRow--, diagonalColumn++) {
      if (board[diagonalRow][diagonalColumn] == 1) {
        return false;
      }
    }

    return true;
  }
}
