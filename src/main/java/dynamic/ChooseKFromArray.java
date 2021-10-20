package dynamic;

import java.util.HashSet;
import java.util.Set;

public class ChooseKFromArray {
  public static void main(String[] args) {
    int[] a = {3, 2, 5, 8};
    int k = 3;
    Set<Integer> result = new HashSet<>();
    chooseKFromInput(a, k, 0, result);
    chooseKFromInputExhaustive(a, k, 0, result);
  }

  private static void chooseKFromInput(final int[] a, final int k, final int beginIndex, Set<Integer> solution) {
    if (solution.size() == k) {
      System.out.println("Choice " + solution);
      return;
    }

    if (beginIndex >= a.length) {
      return;
    }

    for (int i = beginIndex; i < a.length; i++) {
      int item = a[i];
      solution.add(item);
      chooseKFromInput(a, k, i + 1, solution);
      solution.remove(item);
    }
  }

  // This approach will either choose a value or not choose a value - exhaustive
  private static void chooseKFromInputExhaustive(final int[] a, final int k, final int index, Set<Integer> solution) {
    if (solution.size() == k) {
      System.out.println("Choice " + solution);
      return;
    }

    if (index >= a.length) {
      return;
    }

    // include the element
    int item = a[index];
    solution.add(item);
    chooseKFromInput(a, k, index + 1, solution);
    solution.remove(item);

    // do not include the element
    chooseKFromInput(a, k, index + 1, solution);
  }
}
