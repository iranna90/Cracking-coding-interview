package dynamic.onedimensional.recursion;

public class GenerateCombinationOfKElements {
  public static void main(String[] args) {
    int[] input = {3, 2, 5, 8};
    combinationOfK(input, 3, 0, "");
  }

  /*
[3,2,5,8] k=3
    3,2,5
    3,2,8
    3,5,8
    2,5,8
   */
  private static void combinationOfK(int[] input, int k, int index, String result) {
    if (result.length() == k) {
      System.out.println(result);
      return;
    }

    if (index >= input.length) {
      return;
    }

    // including ith element
    combinationOfK(input, k, index + 1, result + input[index]);
    // without ith element
    combinationOfK(input, k, index + 1, result);
  }
}
