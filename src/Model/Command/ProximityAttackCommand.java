package Model.Command;

import Model.Game;
import Model.Hexagon;
import Model.Piece;

import java.util.ArrayList;

public class ProximityAttackCommand extends Command {
    private Hexagon executionLocation;

    public ProximityAttackCommand(Hexagon executionLocation) {
        this.executionLocation = executionLocation;
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
        execute();
    }

}
