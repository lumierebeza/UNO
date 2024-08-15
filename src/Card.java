public class Card {
    private int cardNumber;
    private String cardColor;

    public Card(int cardNumber, String cardColor) {
        this.cardNumber = cardNumber;
        this.cardColor = cardColor;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardColor() {
        return cardColor;
    }

    @Override
    public String toString() {
        return cardColor + " " + cardNumber;
    }
}
