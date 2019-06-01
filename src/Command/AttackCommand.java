package Command;

import java.io.Serializable;
import Model.Hexagon;
import Model.Piece;

public class AttackCommand extends Command implements Serializable
{
    Piece piece;
    Piece targetPiece;
    Hexagon previousPosition;
    Hexagon currentLocation;

    public AttackCommand(Hexagon previousPosition,Hexagon currentLocation)
    {
        this.piece=previousPosition.getPiece();
        this.previousPosition=previousPosition;
        this.currentLocation=currentLocation;
        this.targetPiece=currentLocation.getPiece();
    }

    public boolean execute()
    {
       return piece.getAttackStrategy().execute(previousPosition,currentLocation);
    }

    public void undo()
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