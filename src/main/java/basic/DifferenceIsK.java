package basic;

import java.util.HashSet;
import java.util.Set;

public class DifferenceIsK {
  public static void main(String[] args) {
    int[] input = {1, 7, 5, 9, 2, 12, 3};
    int k = 2;
    pairsBrutForce(input, k);
    System.out.println("===============================");
    pairs(input, k);
  }

  /*
  This is n square
   */
  private static void pairsBrutForce(int[] input, int k) {
    for (int i = 0; i < input.length; i++) {
      for (int j = i + 1; j < input.length; j++) {
        if (Math.abs(input[j] - input[i]) == k) {
          System.out.println("(" + input[i] + " " + input[j] + ")");
        }
      }
    }
  }

  /*
  Using space to avoid extra time
  {1, 7, 5, 9, 2, 12, 3};
   */
  private static void pairs(int[] input, int k) {
    Set<Integer> visited = new HashSet<>(input.length);
    for (int item : input) {
      int remaining = Math.abs(item - k);
      if (visited.contains(remaining)) {
        System.out.println("(" + item + " " + remaining + ")");
      }

      int higher = Math.abs(item + k);
      if (visited.contains(higher)) {
        System.out.println("(" + item + " " + higher + ")");
      }
      visited.add(item);
    }
  }


}
