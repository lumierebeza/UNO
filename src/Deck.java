import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        // Initialize deck with cards
        for (String color : new String[]{"Red", "Yellow", "Green", "Blue"}) {
            for (int i = 0; i <= 9; i++) {
                cards.add(new Card(i, color));
                if (i != 0) {
                    cards.add(new Card(i, color));
                }
            }
            // Add special cards as needed
        }
        Collections.shuffle(cards);
    }

    private void addCard(Card card) {
        cards.add(card);
    }

    public void addCardPublic(Card card) {
        addCard(card);
    }

    public Card takeCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }

    public int getDeckTotal() {
        return cards.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}

