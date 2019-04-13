package Model;

import static java.lang.Math.abs;

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

    public boolean canAttack(Hexagon target){
        return ((abs(this.getX()-target.getX())> this.getPiece().getAttackingDistance() || abs(this.getY()-target.getY()) > this.getPiece().getAttackingDistance()) && this.piece.getAttackingPower() >= target.getPiece().getAttackingPower());
    }

    public void movePiece(Hexagon target) {
        target.setPiece(this.piece);
        this.piece = null;
    }

}
