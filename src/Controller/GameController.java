package Controller;

import Model.Game;
import View.AvengersGameView;

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
     * @return void
     */
    public void click(int x,int y, boolean specialEffect)
    {
        game.click(x, y, specialEffect);

    }

//    public void rightClick(int x,int y)
//    {
//        game.rightClick(x, y);
//    }

    public void registerListener(AvengersGameView view){
        game.addModelChangedListeners(view);
    }

    public void undo()
    {
        game.undo();

    }

    public void replayAllMoves()
    {
        game.replayAllMoves();
    }

    public void saveGame()
    {
        game.saveGame();
    }


}
