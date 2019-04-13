package Controller;

import Model.Game;
import View.AvengersGameView;
import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

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

    public int sum(int a,int b)
    {
        return a+b;
    }
}
