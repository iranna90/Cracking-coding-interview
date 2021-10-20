package array;

public class ReplaceSpaceWithEncoding {
  public static void main(String[] args) {
    String replace = replace("Hi Hello");
    System.out.println(replace);
    char[] result = replaceInPlace("Hi Hello  ".toCharArray(), 8);
    System.out.println(result);
  }

  private static String replace(String input) {
    int numberOfSpaces = 0;
    int i = 0;

    // count number of spaces in the string
    while (i < input.length()) {
      char character = input.charAt(i);
      if (character == ' ') {
        numberOfSpaces++;
      }
      i++;
    }

    // build result by replacing
    StringBuilder result = new StringBuilder(input.length() + (numberOfSpaces * 2));
    for (char character : input.toCharArray()) {
      if (character == ' ') {
        result.append("%20");
      } else {
        result.append(character);
      }
    }

    return result.toString();
  }

  /*
  EMpty spaces at the end of the String, so start from end of the string.
   */
  private static char[] replaceInPlace(char[] input, int actualSize) {

    int numberOfSpaces = 0;
    int i = 0;

    // count number of spaces in the string
    while (i < actualSize) {
      char character = input[i];
      if (character == ' ') {
        numberOfSpaces++;
      }
      i++;
    }

    // build result by replacing
    int position = actualSize + (numberOfSpaces * 2) - 1;
    for (int end = actualSize - 1; end >= 0; end--) {
      char character = input[end];
      if (character == ' ') {
        input[position] = '0';
        input[position - 1] = '2';
        input[position - 2] = '%';
        position = position - 3;
      } else {
        input[position] = character;
        position = position - 1;
      }
    }

    return input;
  }
}
