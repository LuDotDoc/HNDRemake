package Week02.Pontoon;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Pontoon                          *
 *************************************************************************/

public class Card {

    private int value;

    /**
     * Create a new card.
     */
    public Card() {
        this.generateValue();
    }

    /**
     * Generate a new value for the card.
     */
    public void generateValue() {
        this.value = (int)(Math.random() * 10) + 1;
    }

    /**
     * Get the card's value.
     *
     * @return Card's value.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Totals up all given cards and returns their sum value.
     *
     * @param cards Cards
     * @return Sum total of all given cards.
     */
    public static int calculateCards(Card... cards) {
        int total = 0;

        for (Card card : cards) {
            total += card.getValue();
        }

        return total;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }
}

                                                                           
