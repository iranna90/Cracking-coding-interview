package dynamic;


public class BreakTheString {
  public static void main(String[] args) {
    String input = "catsanddog";
    String[] words = {"cat", "cats", "and", "sand", "dog"};
    System.out.println(maxBreak(input, words, input.length() - 1, ""));
  }

  /*

  f(i) ---->

   */
  private static int maxBreak(String string, String[] dictionary, int index, String word) {
    if (index < 0 && word.isEmpty()) {
      return 1;
    }

    if (index < 0) {
      return 0;
    }

    char nextCharacter = string.charAt(index);
    word = nextCharacter + word;

    if (isWordPresent(word, dictionary)) {
      return maxBreak(string, dictionary, index - 1, "") + maxBreak(string, dictionary, index - 1, word);
    }

    return maxBreak(string, dictionary, index - 1, word);
  }

  private static boolean isWordPresent(final String word, final String[] dictionary) {
    for (String w : dictionary) {
      if (w.equals(word)) {
        return true;
      }
    }
    return false;
  }
}
