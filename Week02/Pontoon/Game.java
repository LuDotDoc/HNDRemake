package Week02.Pontoon;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Pontoon                          *
 *************************************************************************/

public class Game {

    private Player player;
    private Deck deck;

    /**
     * Create a new game.
     */
    public Game() {
        this.player = new Player(); // Init player field.
    }

    /**
     * Ask for a new card from the user.
     * @return
     */
    public boolean askNewCard() {
        System.out.println("\n" + this.deck);
        System.out.println("Card total is " + this.deck.getTotal());

        System.out.print("Do you want another card? (Y)es (N)o : ");
        String input = this.player.getInput();

        return input.equalsIgnoreCase("y");
    }

    /**
     * Runs the game.
     */
    public void run() {
        this.deck = new Deck();

        // Add two new cards
        this.deck.addCard(new Card());
        this.deck.addCard(new Card());

        boolean choice = this.askNewCard();

        boolean lost = false;

        while(choice)
        {
            Card newCard = new Card();
            deck.addCard(newCard);

            System.out.println("You drew " + newCard);

            if (this.deck.getTotal() > 21)
            {
                lost = true;
                break; // break the loop if we've lost already
            }
            else if (this.deck.getTotal() == 21)
            {
                break; // break the loop if we've lost already
            }

            choice = askNewCard();
        }

        System.out.println("Your hand consists of:");
        System.out.println(this.deck);

        Deck dealerDeck = new Deck();
        if (lost) {
            System.out.println("You've lost!");
            return;

        } else {
            boolean dealerDunGoofed = false;
            while (!dealerDunGoofed)
            {
                dealerDeck.addCard(new Card());

                if (dealerDeck.getTotal() > 21)
                {
                    dealerDunGoofed = true;
                }
                else if (dealerDeck.getTotal() > 16)
                {
                    break;
                }
            }
        }

        System.out.println("\nDealer's hand consists of:");
        System.out.println(dealerDeck);
        System.out.println("\nYour total is " + this.deck.getTotal());
        System.out.println("Dealer total is " + dealerDeck.getTotal());

        System.out.println(""); // New line

        if (this.deck.getTotal() == dealerDeck.getTotal())
        {
            System.out.println("Draw!");
        }
        else if (this.deck.getTotal() > dealerDeck.getTotal() && this.deck.getTotal() < 22)
        {
            System.out.println("You've won.");
        }
        else
        {
            System.out.println("You've lost.");
        }
    }
}

                                                                           
