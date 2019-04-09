package Controller;

import Model.Game;
import View.AvengersGameView;

public class GameController {
    private Game game;

    public GameController(){
        game = Game.getInstance();
    }

    public void click(int x,int y)
    {
        game.click(x, y);
    }

    public void registerListener(AvengersGameView view){
        game.addModelChangedListeners(view);
    }

}
