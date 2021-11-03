package dynamic.twodimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxSquare {

  public static void main(String[] args) {

    String a = "nssndf.";
    if (a.charAt(a.length()-1) == '.') {
      System.out.println(a.substring(0, a.length()-1));
    }


    List<Integer> firstRow = Stream.of(0, 1, 1).collect(Collectors.toList());
    List<Integer> secondRow = Stream.of(1, 1, 0).collect(Collectors.toList());
    List<Integer> thirdRow = Stream.of(1, 0, 1).collect(Collectors.toList());

    List<List<Integer>> mat = new ArrayList<>();
    mat.add(firstRow);
    mat.add(secondRow);
    mat.add(thirdRow);

    System.out.println(largestArea(mat));
  }

  public static int largestArea(List<List<Integer>> samples) {
    // Write your code here
    int[][] result = new int[samples.size()][samples.get(0).size()];
    for (int row = 0; row < samples.size(); row++) {
      for (int col = 0; col < samples.get(0).size(); col++) {
        result[row][col] = samples.get(row).get(col);
      }
    }
    String positiveKeywords = "a b c";
    Set<String> positive = Arrays.stream(positiveKeywords.split(" ")).collect(Collectors.toSet());

    int max = 0;
    for (int row = 1; row < result.length; row++) {
      for (int col = 1; col < result[0].length; col++) {
        if (result[row][col] == 1) {
          int squareSize = 1 + Math.min(result[row][col - 1], Math.min(result[row - 1][col - 1], result[row - 1][col]));
          result[row][col] = squareSize;
          max = Math.max(max, squareSize);
        }
      }
    }

    return max;
  }
}
