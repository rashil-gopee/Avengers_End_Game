import Model.Game;
import View.AvengersGameView;

import javax.swing.*;

public class AvengersMain {

    public static void main(String args[]) throws Exception {


        Game game = Game.getInstance(2,10);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AvengersGameView(Game.getInstance());
            }
        });
    }

}
