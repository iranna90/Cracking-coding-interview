package bit;

public class CountBitSet {

  public static void main(String[] args) {
    System.out.println(countBitSet(1116));
  }

  private static int countBitSet(int N) {
    System.out.println(Integer.toBinaryString(N));
    int count = 0;
    while (N > 0) {
      int lastBit = N & 1;
      if (lastBit == 1) {
        count++;
      }

      N = N >> 1;
    }

    return count;
  }
}
