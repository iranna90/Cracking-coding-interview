package array;

import java.util.HashSet;
import java.util.Set;

public class StringHasUniqueCharacters {
  public static void main(String[] args) {

  }

  /*
  Using hash table == uses extra O(n) space
   */
  public static boolean hasAllUniqueCharacters(String input) {
    Set<Character> visited = new HashSet<>();
    for (char c: input.toCharArray()) {
      if (visited.contains(c)) {
        return false;
      }
      visited.add(c);
    }

    return true;
  }


}
