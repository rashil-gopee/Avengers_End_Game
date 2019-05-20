package Model;

import java.io.Serializable;

class AttackCommand extends UndoableCommand implements Serializable
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

    public void Execute()
    {
        piece.attack(previousPosition,currentLocation);
    }

    public void Undo()
    {

        targetPiece.setStealth ( targetPiece.getStealth() + piece.getAttackingPower());

    }

    public  void  redo()
    {

    }
}