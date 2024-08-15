import java.util.ArrayList;

public class Pile {
    private ArrayList<Card> cards;

    public Pile() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getTopCard() {
        return cards.isEmpty() ? null : cards.get(cards.size() - 1);
    }

    public void showPile() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public int getPileTotal() {
        return cards.size();
    }

    public Card takeCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }
}

