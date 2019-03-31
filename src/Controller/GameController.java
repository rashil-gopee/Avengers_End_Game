package Controller;

import Model.Game;
import Model.Hexagon;

public class GameController {
    Hexagon selectedHexagon;
    Game game;
    public GameController(Game game) {
        this.game=game;
    }

    public Game getGame() {
        return game;
    }

    public void leftClick(int x, int y) {
        if (selectedHexagon == null) {
            selectedHexagon = game.getBoard().getHexagon(x, y);

            if(selectedHexagon.getPiece()==null|| !selectedHexagon.getPiece().isOwner(game.getPlayer()))
                selectedHexagon=null;
        }
        else {
            Hexagon targetedHex = game.getBoard().getHexagon(x, y);
            boolean move=selectedHexagon.getPiece().move(selectedHexagon, targetedHex);
            if(move)
                changePlayerTurn();

            selectedHexagon = null;
        }
    }

    private void changePlayerTurn() {
        if(game.getPlayerTurn()==0)
            game.setPlayerTurn(1);
        else
            game.setPlayerTurn(0);

    }

    public void rightClick(int x, int y) {
        if(selectedHexagon==null)
        {
            return;
        }
        else{
            Hexagon targetedHex = game.getBoard().getHexagon(x, y);
            if(targetedHex.getPiece()==null)
                return;

            boolean attack=selectedHexagon.getPiece().attack(selectedHexagon,targetedHex);
            if(attack)
                changePlayerTurn();

            selectedHexagon = null;
        }
    }
}
