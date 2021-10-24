package dynamic.previous;

public class Palindrom {
  public static void main(String[] args) {
    String input = "afdsgdfsgbfdsfdsfdgdfz";
    System.out.println(isPalindrom(input, 0, input.length() - 1));
  }

  public static boolean isPalindrom(String input, int startIndex, int endIndex) {

    if (startIndex >= endIndex) {
      return true;
    }

    final char startIndexCharacter = input.charAt(startIndex);
    final char endIndexCharacter = input.charAt(endIndex);

    if (startIndexCharacter != endIndexCharacter) {
      return false;
    }

    return isPalindrom(input, startIndex + 1, endIndex - 1);
  }
}
