package Model;

public class FlyDecorator extends PieceDecorator {

    private Piece piece;

    public FlyDecorator(Piece piece)
    {
        this.piece=piece;

    }

    public void fly(){

    }

}
