package bit;

public class Bits {

  public static void main(String[] args) {
    System.out.println(setZero(6, 2));
    System.out.println(setOne(4, 2));
    System.out.println(setZero(15, 3));
    System.out.println(setOne(11, 3));
  }

  private static int setZero(int item, int pos) {
    int all = ~0;
    int position = 1 << pos -1;

    int mask = all ^ position;

    return item & mask;
  }

  private static int setOne(int item, int pos) {
    int all = 0;
    int position = 1 << pos -1;

    int mask = all ^ position;

    return item | mask;
  }
}
