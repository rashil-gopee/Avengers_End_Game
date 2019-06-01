package Command;

import java.io.Serializable;
import Model.Hexagon;
import Model.Piece;

public class AttackCommand extends UndoableCommand implements Serializable
{
    Piece piece;
    Piece targetPiece;
    Hexagon previousPosition;
    Hexagon currentLocation;

    public AttackCommand(Piece piece, Hexagon previousPosition,Hexagon currentLocation)
    {
        this.piece=piece;
        this.previousPosition=previousPosition;
        this.currentLocation=currentLocation;
        this.targetPiece=currentLocation.getPiece();

    }

    public boolean execute()
    {
       return piece.getAttackStrategy().execute(previousPosition,currentLocation);
    }

    public void Undo()
    {
        targetPiece.setStealth ( targetPiece.getStealth() + piece.getAttackingPower());
        if(currentLocation.getPiece() == null)
        {
            currentLocation.setPiece(targetPiece);
        }

    }

    public void redo()
    {
        piece.getAttackStrategy().execute(previousPosition,currentLocation);
    }
}