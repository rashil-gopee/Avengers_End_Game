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



//
//    if(e.getButton() == MouseEvent.BUTTON1) {
////					System.out.println("Left Click!");
////					gameController.leftClick(game.getBoard().getHexagon(p.x, p.y));
//        if (selectedHex == null && gameController.getGame().getBoard().getHexagon(p.x, p.y).getPiece() !=  null && gameController.getGame().getBoard().getHexagon(p.x, p.y).getPiece().isOwner(gameController.getGame().getPlayer())) {
//            selectedHex = gameController.getGame().getBoard().getHexagon(p.x, p.y);
//        }
//        else if (selectedHex != null && (gameController.getGame().getBoard().getHexagon(p.x, p.y).getPiece() == null || !gameController.getGame().getBoard().getHexagon(p.x, p.y).getPiece().isOwner(gameController.getGame().getPlayer()))) {
//            Hexagon targetedHex  = gameController.getGame().getBoard().getHexagon(p.x, p.y);
//            gameController.movePiece(selectedHex, targetedHex);
//            selectedHex = null;
//        }
//
//    }
//
//				else if(e.getButton() == MouseEvent.BUTTON3) {
//        System.out.println("Right Click!");
//        if (selectedHex != null && (gameController.getGame().getBoard().getHexagon(p.x, p.y).getPiece() == null || !gameController.getGame().getBoard().getHexagon(p.x, p.y).getPiece().isOwner(gameController.getGame().getPlayer()))) {
//            Hexagon targetedHex = gameController.getGame().getBoard().getHexagon(p.x, p.y);
//            gameController.attackPiece(selectedHex, targetedHex);
//        }
//    }

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
