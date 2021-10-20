package basic;

public class Permutation {

  public static void main(String[] args) {
    permutation("abc", "");
  }

  public static void permutation(String input, String result) {
    if (result.length() == input.length()) {
      System.out.println(result);
      return;
    }

    for (Character c : input.toCharArray()) {
      permutation(input, result + c);
    }
  }
}
