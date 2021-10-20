package dynamic;

public class MaxOfArrayRecursion {
  public static void main(String[] args) {
    int[] a = {4, 3, 6, 7, 0, 9, 2};
    System.out.println(maximum(a, a.length));
  }

  private static int maximum(int[] array, int i) {
    if (array == null || array.length == 0) {
      return -1;
    }

    if (i == 0) {
      return array[i];
    }

    int item = array[i - 1];

    return Math.max(item, maximum(array, i - 1));
  }
}
