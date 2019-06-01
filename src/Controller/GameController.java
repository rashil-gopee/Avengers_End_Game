package Controller;

import Model.Game;
import Utilities.FileHelper;
import View.AvengersGameView;

import javax.swing.*;
import java.io.Serializable;
import java.util.Stack;

public class GameController implements Serializable {
    private Game game;

    public GameController(){
        game = Game.getInstance();
    }


    /**
     * This method is used to call the model whenever the player clicks a particular hexagon.
     * calls the respective method.
     * @param x this is x position of the hexagon.
     * @param y this is y position of the hexagon.
     * @return void
     */
    public void click(int x,int y, boolean specialEffect)
    {
        game.click(x, y, specialEffect);

    }


    public void registerListener(AvengersGameView view){
        game.addModelChangedListeners(view);
    }

    public void undo(int undo)
    {
        game.undo(undo);

    }
    public void goToNode(int id)
    {
      game.goToNode(id);
    }
    public void replayAllMoves()
    {
        game.replayAllMoves();
    }

    public void saveGame()
    {
        game.saveGame();
    }

    public void loadGame() {
        FileHelper fileHelper=new FileHelper();
        Game game=fileHelper.loadObjectToFile();
        Game.setInstance(game);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AvengersGameView(Game.getInstance());
            }
        });
       }

       public void startNewGame(String strategy)
       {
           Game.getInstance(2,10,strategy);
           SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   new AvengersGameView(Game.getInstance());
               }
           });
       }
}
