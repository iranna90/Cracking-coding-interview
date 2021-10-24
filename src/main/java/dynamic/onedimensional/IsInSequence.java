package dynamic.onedimensional;

public class IsInSequence {
  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5, 6};
    System.out.println(inSequence(input, input.length - 1));
    input = new int[] {1, 3, 4, 5, 6};
    System.out.println(inSequence(input, input.length - 1));
  }

  // 1,2,3,4,5,6
  private static boolean inSequence(int[] input, int index) {
    if (index <= 0) {
      return true;
    }

    return input[index] - input[index - 1] == 1 && inSequence(input, index - 1);
  }
}
