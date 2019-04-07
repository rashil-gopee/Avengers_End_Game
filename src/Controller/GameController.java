package Controller;

import Model.Game;

public class GameController {
    private Game game;

    public GameController(){
        game = Game.getInstance(2);
    }

    public Game getGame() {
        return game;
    }

    public void movePiece(int x,int y) {
        boolean move;
        if(game.getSelectedHexagon()==null)
        {
            game.setSelectedHexagon(game.getBoard().getHexagon(x,y));
        }
        else
        {
            move = game.getSelectedHexagon().getPiece().move(game.getSelectedHexagon(),game.getBoard().getHexagon(x,y));
            if (move) {
                game.changePlayerTurn();
            }
            game.setSelectedHexagon(null);
        }
    }

    public void attackPiece(int x,int y) {
        boolean move;
        if(game.getSelectedHexagon()==null)
        {
            game.setSelectedHexagon(game.getBoard().getHexagon(x,y));
        }
        else
        {
            move = game.getSelectedHexagon().getPiece().attack(game.getSelectedHexagon(),game.getBoard().getHexagon(x,y));
            if (move) {
                game.changePlayerTurn();
            }
            game.setSelectedHexagon(null);
        }
    }
}
