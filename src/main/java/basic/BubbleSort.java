package basic;

import java.util.List;

public class BubbleSort {
  public static void main(String[] args) {
    String hlowrd_el_ol = decodeString(2, "hlowrd_el_ol");
    System.out.println(hlowrd_el_ol);
  }


  public static String decodeString(int numberOfRows, String encodedString) {
    int length = encodedString.length();
    int columns = length / numberOfRows;
    // create matrix
    char[][] encodedResult = new char[numberOfRows][columns];
    // hlowrd_el_ol
    int index = 0;
    // fill the matrix
    char underScore = '_';
    char replacement = ' ';
    for (int row = 0; row < encodedResult.length; row++) {
      for (int col = 0; col < encodedResult[0].length; col++) {
        char character = encodedString.charAt(index);
        if (character == underScore) {
          encodedResult[row][col] = replacement;
        } else {
          encodedResult[row][col] = character;
        }
        index += 1;
      }
    }

    int col = 0;
    StringBuilder result = new StringBuilder();
    while (col < encodedResult[0].length) {
      getThisDiaganolData(col, encodedResult, result);
      col++;
    }

    return result.toString();
  }

  private static void getThisDiaganolData(int col, char[][] encodedResult, StringBuilder result) {
    // find original string

    for (int row = 0; row < encodedResult.length & col < encodedResult[0].length; row++) {
      char item = encodedResult[row][col];
      result.append(item);
      col = col + 1;
    }
  }


  // 5, 1, 4, 2 === 1, 5, 4 ,2 == i = 0
  // i = 1 ==== 1, 5, 4 ,2 == j = 2 -->  1, 4, 5, 2 -- j = 3 --- 1, 2, 5, 4
  // i = 2 ==== 1, 2, 5, 4 === j= 3 ---> 1, 2, 4, 5 == j 4
  public static long howManySwaps(List<Integer> arr) {
    Integer[] values = arr.toArray(new Integer[0]);
    int i = 0;
    long swaps = 0;
    while (i < values.length) {
      int item = values[i];
      int j = i + 1;
      while (j < values.length) {
        int nextItem = values[j];
        // swap
        if (item > nextItem) {
          values[i] = nextItem;
          values[j] = item;
          item = nextItem;
          swaps += 1;
        }
        j++;
      }
      i++;
    }

    return swaps;
  }
}
