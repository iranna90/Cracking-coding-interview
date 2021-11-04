package bit;

public class PrintNextAndPrevIntWithSameOnes {

  /*
  Brute force: next largest: Add one and check whether it has same number of 1's and return first occurrence, or result is Integer.MAX.
  next smallest: Subtract 1: and has same ones and repeat until you get all ones or result is zero
   */
  public static void main(String[] args) {

  }
  /*
  1001010101
  i position of 0
  j position of 1
  for large: Find i and j such that i > j(should start from zero position)--> and then flip the bits
  for small: Find i and j such that j > i ----> flip
   */
  private static void optimal(int N) {
    int i =0;
    int j=0;


   int result = flip(N, i, j);
  }

  private static int flip(final int n, final int i, final int j) {
    int allOnes = ~0;
    int flipToOne = 1 << i;

    return 0;
  }
}
