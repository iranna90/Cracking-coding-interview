package dynamic.onedimensional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given string S
And dictionary of words: W
print all different words combination can be used to break this S into multiple small words from W.
S: catsanddog
W: [cat, cats, and, sand, dog]
 */
public class StringAndWordDictionary {
  public static void main(String[] args) {
    Set<String> dictionary = Stream.of("cat", "cats", "and", "sand", "dog").collect(Collectors.toSet());
    String input = "catsanddog";
    printComb(input, dictionary, input.length() - 1, "", new HashSet<>());

    input = "catanddog";
    printComb(input, dictionary, input.length() - 1, "", new HashSet<>());

    input = "catandog";
    printComb(input, dictionary, input.length() - 1, "", new HashSet<>());

    printComb(null, dictionary, 0, "", new HashSet<>());

    printComb("", dictionary, 0, "", new HashSet<>());


    printComb("", null, 0, "", new HashSet<>());
    printComb("", new HashSet<>(), 0, "", new HashSet<>());
  }

  private static void printComb(String input, Set<String> dictionary, int index, String sub, Set<String> result) {

    if (input == null || input.length() == 0 || dictionary == null || dictionary.isEmpty()) {
      return;
    }

    if (index < 0 && sub.length() == 0) {
      System.out.println(result);
      return;
    }

    // not found
    if (index < 0) {
      return;
    }

    char c = input.charAt(index);
    sub = c + sub;
    if (dictionary.contains(sub)) {
      Set<String> newResult = new HashSet<>(result);
      newResult.add(sub);
      printComb(input, dictionary, index - 1, "", newResult);
    }

    printComb(input, dictionary, index - 1, sub, result);
  }
}
