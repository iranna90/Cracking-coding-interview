package bit;

import java.util.ArrayList;
import java.util.List;

public class FlipBit {

  public static void main(String[] args) {
    System.out.println(maxCountOneFlip(1775));
  }

  private static int maxCountOneFlip(int number) {
    List<Integer> zerosPosition = new ArrayList<>();
    int position = 1;
    while (number > 0) {
      int lastItem = number & 1;
      if (lastItem == 0) {
        zerosPosition.add(position);
      }

      number = number >> 1;
      position++;
    }

    int maxCount = 0;
    int prev = 0;
    for (int i = 0; i < zerosPosition.size() - 1; i++) {
      int nextPosition = zerosPosition.get(i + 1);
      int countFlippingThisItem = nextPosition - prev - 1;
      maxCount = Math.max(maxCount, countFlippingThisItem);
    }

    return maxCount;
  }
}
