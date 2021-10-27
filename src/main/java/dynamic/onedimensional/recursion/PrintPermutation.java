package dynamic.onedimensional.recursion;

import java.util.HashSet;
import java.util.Set;

public class PrintPermutation {
  public static void main(String[] args) {
    int[] input = {1, 2, 3};
    permutation(input, new HashSet<>(), "");
  }

  private static void permutation(int[] input, Set<Integer> used, String result) {
    if (used.size() == input.length) {
      System.out.println(result);
      return;
    }

    for (int item : input) {
      if (!used.contains(item)) {
        used.add(item);
        permutation(input, used, result + item + " ");
        used.remove(item);
      }
    }
  }

}
