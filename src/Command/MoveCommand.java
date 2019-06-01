package Command;

import java.io.Serializable;
import Command.UndoableCommand;
import Model.Hexagon;
import Model.Piece;

public class MoveCommand extends UndoableCommand implements Serializable{
    Piece piece;
    Hexagon previousPosition;
    Hexagon currentLocation;
    public MoveCommand( Hexagon previousPosition,Hexagon currentLocation)
    {
        this.piece=previousPosition.getPiece();
        this.previousPosition=previousPosition;
        this.currentLocation=currentLocation;
    }

    public boolean execute()
    {
        return piece.move(previousPosition,currentLocation);
    }

    public  void Undo()
    {
        piece.move(currentLocation,previousPosition);
    }

    public void redo()
    {
        piece.move(previousPosition,currentLocation);
    }
}