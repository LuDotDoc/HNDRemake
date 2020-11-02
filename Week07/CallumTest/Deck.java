package Week07.CallumTest;
import Week07.CallumTest.Card.Rank;
import Week07.CallumTest.Card.Suit;
/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week07.CallumTest                          *
 *************************************************************************/

public class Deck {

    private Card[] cards = new Card[52];

    /**
     * Creates a new deck
     */
    public Deck() {
        reloadDeck();
    }

    /**
     * Iterates through suit and rank enums
     * Assigns each index a card
     */
    public final void reloadDeck() {
        int i = 0;
        for (Suit suit : Suit.values())
        {
            for (Rank rank : Rank.values())
            {
                cards[i++] = new Card(suit, rank);
            }
        }
    }

    /**
     *
     * @return card - Randomly chosen card
     */
    public Card drawCard() {
        Card card = null;
        while (card == null)
        {
            int index = (int)(Math.random()*cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }

}

                                                                           
