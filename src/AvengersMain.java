import Controller.GameController;
import Model.Attacker;
import Model.Attackers.BlackPanther;
import Model.Attackers.CaptainMarvel;
import Model.Attackers.DrStrange;
import Model.Attackers.IronMan;
import Model.Defenders.KillMonger;
import Model.Defenders.Loki;
import Model.Defenders.Thanos;
import Model.Defenders.Ultron;
import Model.Game;
import Model.Piece;
import Model.Player;
import View.AvengersGameView;

import javax.swing.*;
import java.util.ArrayList;

public class AvengersMain {

    public static void main(String args[]) throws Exception {
        ArrayList<Player> playerList=new ArrayList();
        playerList.add(new Player("Player 1"));
        playerList.add(new Player("Player 2"));
        Game game=new Game(playerList);
        GameController gameController=new GameController(game);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AvengersGameView(gameController);
            }
        });

    }

}
