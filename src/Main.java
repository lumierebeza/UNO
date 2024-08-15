import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for player's name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Ask for number of players
        System.out.print("Enter number of players (including yourself): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Create players array
        Player[] players = new Player[numPlayers];
        players[0] = new Player(playerName);

        for (int i = 1; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + "'s name: ");
            String name = scanner.nextLine();
            players[i] = new Player(name);
        }

        // Start the game with created players
        startGame(players, scanner);
    }

    public static void startGame(Player[] players, Scanner scanner) {
        Deck deck = new Deck();
        Pile pile = new Pile();

        // Deal 7 cards to each player
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.takeDealtCard(deck.takeCard());
            }
        }

        // Place the first card on the pile
        pile.addCard(deck.takeCard());

        // Basic game loop
        boolean gameWon = false;
        int currentPlayerIndex = 0;

        while (!gameWon) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("\n" + currentPlayer.getName() + "'s turn:");

            // Show current player's hand
            currentPlayer.getHand().showHand();
            System.out.println("Top card on pile: " + pile.getTopCard());

            // Ask the player to choose a card to play or to draw a card
            System.out.print("Choose a card to play (1-" + currentPlayer.getHand().getHandTotal() + ") or 0 to draw a card: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (choice == 0) {
                // Player chooses to draw a card
                currentPlayer.drawCard(deck);
                System.out.println(currentPlayer.getName() + " draws a card");
            } else {
                // Player chooses a card to play
                Card cardToPlay = currentPlayer.getHand().getCard(choice - 1);
                if (currentPlayer.checkMatch(cardToPlay, pile.getTopCard())) {
                    pile.addCard(currentPlayer.playCard(choice - 1));
                    System.out.println(currentPlayer.getName() + " plays " + cardToPlay);
                } else {
                    System.out.println("Invalid card selection. Please draw a card.");
                    currentPlayer.drawCard(deck);
                }
            }

            if (currentPlayer.checkWin()) {
                System.out.println(currentPlayer.getName() + " wins the game!");
                gameWon = true;
            }

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
    }
}



