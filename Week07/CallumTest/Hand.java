package Week07.CallumTest;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import Week07.CallumTest.Card.Rank;
/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week07.CallumTest                          *
 *************************************************************************/

public class Hand {

    /**
     * Observable list for event listeners
     * Node used to deal with elements' children eg.Card has (cardBacks, values)
     */
    private ObservableList<Node> cards;
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);
    //private Integer bet;
    private int aces = 0;

    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    /**
     * Adds the value of a new card to the hand.
     * Checks if there are aces and sets them = 1 iff (aces > 1) && (hand > 21)
     * @param card - New card to be added to the hand
     */
    public void takeCard(Card card) {
        cards.add(card);

        if (card.rank == Rank.ACE) {
            aces++;
        }

        if (value.get() + card.value > 21 && aces > 0) {
            value.set(value.get() + card.value - 10);
            aces --;
        }
        else
        {
            value.set(value.get() + card.value);
        }
    }

    /**
     * Sets default values
     */
    public void reset() {
        cards.clear();
        value.set(0);
        aces = 0;
    }

    /**
     * @return value - Integer value of hand total
     */
    public SimpleIntegerProperty getValue() {
        return value;
    }

    /*public void setBet(Integer bet) {
        this.bet = bet;
    }*/
}
                                                                           
