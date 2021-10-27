package dynamic.onedimensional.recursion;

public class SumOfDigits {
  public static void main(String[] args) {
    System.out.println(sumOfDigits(9));
    System.out.println(sumOfDigits(19));
    System.out.println(sumOfDigits(99));
    System.out.println(sumOfDigits(123456));
  }

  private static int sumOfDigits(int number) {
    if (number < 10) {
      return number;
    }

    int reminder = number % 10;
    int remaining = number / 10;
    return reminder + sumOfDigits(remaining);
  }
}
