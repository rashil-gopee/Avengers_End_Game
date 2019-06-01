package Command;

import Model.Game;
import Model.Hexagon;
import Model.Piece;

import java.io.Serializable;
import java.util.ArrayList;

public class ProximityAttackCommand extends Command implements Serializable {
    Hexagon executionLocation;

    public ProximityAttackCommand(Hexagon executionLocation) {
//        this.piece=oldLocation.getPiece();
        this.executionLocation = executionLocation;
//        this.newLocation = newLocation;
    }

    public boolean execute()
    {
        ArrayList<Hexagon> surroundingHexagons = executionLocation.getSurroundHexagons();

        for (Hexagon hex : surroundingHexagons) {
            Piece pieceToAttack = Game.getHexagonPiece(hex.getX(), hex.getY());

            if (pieceToAttack != null) {
                pieceToAttack.suffer(2);
            }
        }
        return true;
    }

    public void undo(){
        ArrayList<Hexagon> surroundingHexagons = executionLocation.getSurroundHexagons();

        for (Hexagon hex : surroundingHexagons) {
            Piece pieceToAttack = Game.getHexagonPiece(hex.getX(), hex.getY());

            if (pieceToAttack != null) {
                pieceToAttack.heal(2);
            }
        }
    }

    public void redo(){
//        piece.move(oldLocation,newLocation);

        ArrayList<Hexagon> surroundingHexagons = executionLocation.getSurroundHexagons();

        for (Hexagon hex : surroundingHexagons) {
            Piece pieceToAttack = Game.getHexagonPiece(hex.getX(), hex.getY());

            if (pieceToAttack != null) {
                pieceToAttack.suffer(2);
            }
        }
    }

}
