package object.cards;

public class Card {
  private final Type type;
  private final Value value;
  private boolean available = true;

  public Card(final Type type, final Value value) {
    this.type = type;
    this.value = value;
  }

  public void userCard() {
    available = false;
  }

  public static void main(String[] args) {
    int[] a = new int[20];
    System.out.println(a.length);
  }
}
