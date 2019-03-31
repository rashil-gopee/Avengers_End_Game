package Controller;

import Model.Game;
import Model.Hexagon;

public class GameController {
    private Game game;

    public GameController(){
        game = game = new Game(2);
    }

    public Game getGame() {
        return game;
    }

    public void movePiece(Hexagon source, Hexagon target) {
        if (target.getPiece() == null && source.getPiece() !=null && source.getPiece().isOwner(game.getPlayer())) {
            boolean move= source.getPiece().move(source, target);

            if(move) {
                changePlayerTurn();
            }
        }
    }

    private void changePlayerTurn() {
        if (game.getPlayerTurn() == (game.getPlayers().size() - 1)){
            game.setPlayerTurn(0);
        }
        else
            game.setPlayerTurn(game.getPlayerTurn() + 1);
    }

    public void attackPiece(Hexagon source, Hexagon targetedHex) {
        if (source.getPiece() != null && targetedHex.getPiece() !=null) {
            boolean attack=source.getPiece().attack(source,targetedHex);
            if (attack)
                changePlayerTurn();
        }
    }
}
