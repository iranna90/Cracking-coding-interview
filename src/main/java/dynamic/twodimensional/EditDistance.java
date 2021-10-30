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
}
