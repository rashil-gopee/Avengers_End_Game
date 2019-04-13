package Model;


import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class Hexagon {
    private int x;
    private int y;
    private Piece piece;

    public Hexagon(int x,int y) {
        this.x=x;
        this.y=y;
        this.piece = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Requires("piece != null && target.getPiece() == null")
    @Ensures("target.getPiece != null && piece == null")
    public void movePiece(Hexagon target) {
        target.setPiece(this.piece);
        this.piece = null;
    }

}
