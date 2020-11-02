package Week07.CallumTest;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.HBox;
/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week07.CallumTest                          *
 *************************************************************************/

public class Player {

    private Hand hand;
    private SimpleIntegerProperty cash;
    private Integer bet;

    public Player(HBox cardBox, SimpleIntegerProperty cash) {
        this.hand = new Hand(cardBox.getChildren());
        this.cash = cash;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public void collectWinnings(Integer winnings) {
        this.cash.setValue(cash.getValue() + winnings);
    }

    public Integer getBet() {
        return this.bet;
    }

    public Hand getHand() {
        return this.hand;
    }

    public SimpleIntegerProperty getCash() {
        return this.cash;
    }
}

                                                                           
