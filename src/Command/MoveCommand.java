package Command;

import java.io.Serializable;
import Command.UndoableCommand;
import Model.Hexagon;
import Model.Piece;

public class MoveCommand extends UndoableCommand implements Serializable{
    Piece piece;
    Hexagon previousPosition;
    Hexagon currentLocation;
    public MoveCommand(Piece piece, Hexagon previousPosition,Hexagon currentLocation)
    {
        this.piece=piece;
        this.previousPosition=previousPosition;
        this.currentLocation=currentLocation;
    }

    public void Execute()
    {
        piece.move(previousPosition,currentLocation);
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