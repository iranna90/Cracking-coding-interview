package dynamic.onedimensional.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
  public static void main(String[] args) {
    int[] input = {1, 2, 3};
    List<String> result = new ArrayList<>();
    subSets(input, 0, result, "");
    System.out.println(result);
  }

  private static void subSets(int[] input, int index, List<String> results, String partialResult) {

    if (index == input.length) {
      results.add(partialResult);
      return;
    }

    int item = input[index];

    subSets(input, index + 1, results, partialResult + item);
    subSets(input, index + 1, results, partialResult);
  }
}
