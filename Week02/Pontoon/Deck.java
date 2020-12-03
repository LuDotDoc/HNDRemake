package Week02.Pontoon;

import java.util.ArrayList;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Pontoon                                  *
 *************************************************************************/

public class Deck {

    private ArrayList<Card> store;

    /**
     * Constructor to create a new deck
     */
    public Deck() {
        this.store = new ArrayList<Card>();         //array list was used because it is expandable and does not have a fixed size.
    }

    /**
     * Add a card to the deck.
     * @param card
     */
    public void addCard(Card card) {
        this.store.add(card);
    }

    /**
     * Get the total of all cards in the store.
     * @return
     */
    public int getTotal() {
        int total = 0;

        for (int i = 0; i < this.store.size(); i++) {
            total += this.store.get(i).getValue();
        }

        return total;
    }

    /**
     * Get a specific card at the given index.
     *
     * @param index
     * @return
     */
    public Card getCard(int index) {
        return this.store.get(index);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < this.store.size(); i++) {
            str += "\nCard: " + (i + 1) + " value: " + this.store.get(i).getValue();
        }

        return str.trim();
    }
}

                                                                           
