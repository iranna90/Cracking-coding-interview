package dynamic.twodimensional;

public class EditDistance {

  /*
  1. Insert a character
  2. Replace a character
  3. Delete a character
   */
  public static void main(String[] args) {
    String a = "GOAT";
    String b = "GET";
    System.out.println(minED(a, a.length() - 1, b, b.length() - 1));
    System.out.println(iterative(a, b));
  }

  private static int minED(String a, int firstIndex, String b, int secondIndex) {
    if (firstIndex < 0 && secondIndex < 0) {
      return 0;
    }

    if (firstIndex < 0) {
      return secondIndex + 1;
    }

    if (secondIndex < 0) {
      return firstIndex + 1;
    }

    if (a.charAt(firstIndex) == b.charAt(secondIndex)) {
      return minED(a, firstIndex - 1, b, secondIndex - 1);
    }

    int insertDistance = minED(a, firstIndex - 1, b, secondIndex);
    int replaceDistance = minED(a, firstIndex - 1, b, secondIndex - 1);
    int deleteDistance = minED(a, firstIndex, b, secondIndex - 1);
    return 1 + Math.min(Math.min(insertDistance, replaceDistance), deleteDistance);
  }


  private static int iterative(String a, String b) {
    int[][] result = new int[a.length() + 1][b.length() + 1];

    // fill first column
    for (int row = 0; row <= a.length(); row++) {
      result[row][0] = row;
    }

    // fill first row
    for (int col = 0; col <= b.length(); col++) {
      result[0][col] = col;
    }

    // ab
    // bc
    for (int i = 1; i <= a.length(); i++) {
      for (int j = 1; j <= b.length(); j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          result[i][j] = result[i - 1][j - 1];
        } else {
          int insert = result[i-1][j];
          int replace = result[i-1][j-1];
          int delete = result[i][j-1];
          result[i][j] = 1 + Math.min(insert, Math.min(replace, delete));
        }
      }
    }

    return result[a.length()][b.length()];
  }
}
