package dynamic;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfArray {
  public static void main(String[] args) {
    int a[] = {1, 2};
    Set<Integer> used = new HashSet<>();
    permutation(a, "", used);
  }

  private static void permutation(int[] input, String result, Set<Integer> used) {
    if (result.length() == input.length) {
      System.out.println("Permutation " + result);
      return;
    }

    for (int element : input) {
      // already used character
      if (!used.contains(element)) {
        used.add(element);
        permutation(input, result + element, used);
        used.remove(element);
      }
    }
  }
}
