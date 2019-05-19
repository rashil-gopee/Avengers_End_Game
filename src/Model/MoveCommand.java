package Model;

class MoveCommand extends UndoableCommand
{

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
        System.out.println("Heyyyy");
        piece.move(previousPosition,currentLocation);
    }
}