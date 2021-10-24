package dynamic.previous;

public class SequenceCheck {

  public static void main(String[] args) {
    int[] a = {2, 3, 4, 5, 6, 7};
    System.out.println(inSequence(a, a.length));
  }

  public static boolean inSequence(int[] data, int i) {
    if (i <= 1) {
      return true;
    }

    int item = data[i - 1];
    return (item - data[i - 2] == 1) && inSequence(data, i - 1);
  }
}
