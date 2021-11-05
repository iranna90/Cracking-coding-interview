package object.cards;

public enum Type {
  CLUB(0),
  DIAMOND(1),
  HEART(2),
  SPADE(3);
  private final int value;

  Type(final int value) {
    this.value = value;
  }
}
