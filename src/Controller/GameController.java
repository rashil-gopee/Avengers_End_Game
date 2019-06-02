package Controller;

import Model.Game;
import Model.Utilities.FileHelper;
import View.AvengersGameView;

import javax.swing.*;
import java.io.Serializable;

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
     * @param specialEffect this is to represent if the player played a special move.
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

    /**
     * This method is used to load an existing game. Once the game is loaded
     * it calls the main view.
     * @return void
     */
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

    /**
     * This method is used to setup a new game based on the strategy the player
     * has decided.
     * @param strategy this is game strategy the player wants to play.
     * @return void
     */
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
