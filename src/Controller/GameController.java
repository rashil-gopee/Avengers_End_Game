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

            if(selectedHexagon.getPiece()==null)
                selectedHexagon=null;
        }
        else {
            Hexagon targetedHex = game.getBoard().getHexagon(x, y);
            selectedHexagon.getPiece().move(selectedHexagon,targetedHex);
            selectedHexagon = null;
        }
    }
}
