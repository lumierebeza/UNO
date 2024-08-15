import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getCard(int index) {
        return index >= 0 && index < cards.size() ? cards.get(index) : null;
    }

    public int getHandTotal() {
        return cards.size();
    }

    public Card removeCard(int index) {
        return index >= 0 && index < cards.size() ? cards.remove(index) : null;
    }

    public void showHand() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
