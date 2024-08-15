public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void takeDealtCard(Card card) {
        hand.addCard(card);
    }

    public Card playCard(int index) {
        return hand.removeCard(index);
    }

    public boolean checkMatch(Card card1, Card card2) {
        return card1.getCardColor().equals(card2.getCardColor()) || card1.getCardNumber() == card2.getCardNumber();
    }

    public void finishTurn() {
        // Implement logic to finish turn
    }

    public boolean checkUno() {
        return hand.getHandTotal() == 1;
    }

    public boolean checkWin() {
        return hand.getHandTotal() == 0;
    }

    public void drawCard(Deck deck) {
        hand.addCard(deck.takeCard());
    }
}

