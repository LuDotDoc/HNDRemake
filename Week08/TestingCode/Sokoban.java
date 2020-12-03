package Week08.TestingCode;
import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;

public class Sokoban extends JFrame {


    private final int OFFSET = 28;

    public Sokoban() {

        initUI();
    }

    private void initUI() {

        Board board = new Board();
        add(board);

        setTitle("Sokoban");

        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2 * OFFSET);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){



        EventQueue.invokeLater(() -> {

            Sokoban game = new Sokoban();
            game.setVisible(true);
        });
    }
}


