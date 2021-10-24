package dynamic.previous;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {
  public static void main(String[] args) {
    String input = "god";
    anagrams(input, new ArrayList<>());
  }

  private static void anagrams(String input, List<Character> solution) {

    if (solution.size() == input.length()) {
      System.out.println(solution);
      return;
    }

    for (int i = 0; i < input.length(); i++) {
      char nextCharacter = input.charAt(i);
      if (!solution.contains(nextCharacter)) {
        solution.add(nextCharacter);
        anagrams(input, solution);
        solution.removeIf(item -> item == nextCharacter);
      }
    }
  }
}
