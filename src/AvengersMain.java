import Model.Game;
import View.AvengersGameView;

import javax.swing.*;

public class AvengersMain {

    public static void main(String args[]) throws Exception {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AvengersGameView();
            }
        });
    }

}
