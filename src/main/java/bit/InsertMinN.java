package bit;

/*
Given two 32-bit numbers, N and M, and two-bit positions, i and j.
Write a method to insert M into N such that M starts at bit j and ends at bit i.
You can assume that the bits j through i have enough space to fit all of M.
Assuming index start from 0.
 */
/*
  N = 1024 (10000000000),
    M = 19 (10011),
    i = 2, j = 6
     Output : 1100 (10001001100)
 */
public class InsertMinN {

  public static void main(String[] args) {
    System.out.println(insert(30, 5, 1, 3));
    System.out.println(setOnesBetween(1, 2));
  }

  private static int setOnesBetween(int i, int j) {
    int allOne = ~0;
    // set all ones before j
    int beforeJOnes = allOne << (j + i);

    // set all below i as ones
    int afterIOnes = (1 << i) - 1;

    int mask = beforeJOnes | afterIOnes;

    return allOne & mask;
  }

  private static int insert(int N, int M, int i, int j) {
    // need to set all the fields at that location in N to zero
    int reset = 0;
    for (int position = j; position >= i; position--) {
      int pos = 1 << position;
      reset = reset | pos;
    }

    N = N ^ reset;

    M = M << i;

    return N | M;
  }
}
