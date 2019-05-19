package Model;

public class Fly extends PieceDecorator {
    private  Piece piece;

    public Fly(Piece p) {
        this.piece = p;
    }

    public void fly() {
        System.out.println("I'm Flying");
    }
}
