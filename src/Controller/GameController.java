package Controller;

import Model.Game;
import Model.Hexagon;

import java.awt.event.MouseEvent;

public class GameController {
    private Game game;

    public GameController(){
        game = game = new Game(2);
    }

    public Game getGame() {
        return game;
    }

    public void movePiece(int x,int y) {
        boolean move=false;
        if(game.getSelectedHexagon()==null)
        {
            game.setSelectedHexagon(game.getBoard().getHexagon(x,y));
        }
        else
        {
            move = game.getSelectedHexagon().getPiece().move(game.getSelectedHexagon(),game.getBoard().getHexagon(x,y));
            game.setSelectedHexagon(null);
        }
        if (move) {
            game.changePlayerTurn();
        }
    }

    public void attackPiece(int x,int y) {
        boolean move=false;
        if(game.getSelectedHexagon()==null)
        {
            game.setSelectedHexagon(game.getBoard().getHexagon(x,y));
        }
        else
        {
            move = game.getSelectedHexagon().getPiece().attack(game.getSelectedHexagon(),game.getBoard().getHexagon(x,y));
            game.setSelectedHexagon(null);
        }
        if (move) {
            game.changePlayerTurn();
        }
    }
}
