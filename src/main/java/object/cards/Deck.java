package object.cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
  private static final int DECK_SIZE = 52;
  List<Card> cards = new ArrayList<>(52);

  public Deck() {
    createDeck();
  }

  private void createDeck() {
    for (Type type: Type.values()) {
      // generate 13 cards
      for (Value value: Value.values()) {
        Card card = new Card(type, value);
        cards.add(card);
      }
    }
  }

  public void shuffle() {
    for (int time=0; time < DECK_SIZE; time++) {
        // generate 2 random number and swap them.
    }
  }

  public Card getNext() {
    //
    return null;
  }
}
