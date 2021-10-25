package dynamic.onedimensional;

import java.util.HashSet;
import java.util.Set;

public class Anagrams {

  public static void main(String[] args) {
    printAnagrams("god", "", new HashSet<>());
    System.out.println();
    printAnagrams("", "", new HashSet<>());
    System.out.println();
    printAnagrams(null, "", new HashSet<>());
    System.out.println();
    printAnagrams("a", "", new HashSet<>());
  }

  private static void printAnagrams(String input, String result, Set<Character> used) {
    if (input == null || input.length() == 0) {
      return;
    }

    if (input.length() == 1) {
      System.out.println(input);
      return;
    }

    if (result.length() == input.length()) {
      System.out.println(result);
      return;
    }

    for (char c : input.toCharArray()) {
      if (!used.contains(c)) {
        used.add(c);
        printAnagrams(input, result + c, used);
        used.remove(c);
      }
    }
  }

}
