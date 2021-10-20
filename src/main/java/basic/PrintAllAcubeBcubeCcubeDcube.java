package basic;

import java.util.HashMap;
import java.util.Map;

/*
given n
print a^3 + b^3 = c^3+d^3
 */
public class PrintAllAcubeBcubeCcubeDcube {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    printBruteForce(10);
    long end = System.currentTimeMillis();
    System.out.println("==========================" + (end - start));

    start = System.currentTimeMillis();
    optimal(10);
    end = System.currentTimeMillis();
    System.out.println("==========================" + (end - start));
  }

  private static void printBruteForce(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        for (int c = 1; c <= n; c++) {
          for (int d = 1; d <= n; d++) {
            if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
              System.out.println("(" + a + " " + b + " " + c + " " + d + ")");
            }
          }
        }
      }
    }
  }

  /*
    a^3+b^3 = c^3 + d^3
    d^3 = a^3+b^3-c^3
    d = cubeRoot(a^3+b^3-c^3)
   */
  private static void optimal(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        for (int c = 1; c <= n; c++) {
          double aCube = Math.pow(a, 3);
          double bCube = Math.pow(b, 3);
          double cCube = Math.pow(c, 3);
          int d = (int) Math.cbrt(aCube + bCube - cCube);
          if (d >= 1 && d <= 10 && aCube + bCube == cCube + Math.pow(d, 3)) {
            System.out.println("(" + a + " " + b + " " + c + " " + d + ")");
          }
        }
      }
    }
  }

  /*
  Second step of optimization is find all combination of c and d cube root sum and for every combination of a and b find corresponding c and d
   */
  private static void optimalSecond(int n) {
    Map<Integer, String> cAndDCombination = new HashMap<>();

    for (int c = 1; c <= n; c++) {
      for (int d = 1; d <= n; d++) {
        int result = (int) (Math.pow(c, 3) + Math.pow(d, 3));
        cAndDCombination.put(result, "" + c + " " + d);
      }
    }

    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        int result = (int) (Math.pow(a, 3) + Math.pow(b, 3));
        String cAndDPair = cAndDCombination.get(result);
        if (cAndDPair != null) {
          System.out.println();
        }
      }
    }
  }

}

