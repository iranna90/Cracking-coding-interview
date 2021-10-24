package dynamic.previous;

public class SumOfTheDigits {
  public static void main(String[] args) {
    int a = 123456;
    System.out.println(sum(a));
  }

  private static int sum(int number) {
    if (number <= 9) {
      return number;
    }

    int digit = number % 10;
    int remaining = number / 10;
    return digit + sum(remaining);
  }
}
